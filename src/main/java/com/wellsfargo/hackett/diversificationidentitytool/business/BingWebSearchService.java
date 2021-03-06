package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class BingWebSearchService {

    @Value("${hackett-bing.search.api.subscription.key}")
    String subscriptionKey;

    @Value("${hackett-bing.search.api.endpoint}")
    String endpoint;

    @Value("${hackett-bing.search.api.results.limit}")
    String limit;

    public BingWebSearchResponse searchWeb(String searchQuery) throws Exception {
        // Construct URL of search request (endpoint + query string)
        URL url = new URL(endpoint + "?q=" + URLEncoder.encode(searchQuery, "UTF-8") + "&count=" + limit);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);

        // Receive JSON body
        InputStream stream = connection.getInputStream();
        Scanner scanner = new Scanner(stream);
        String response = scanner.useDelimiter("\\A").next();

        // Construct result object for return
        SearchResults results = new SearchResults(new HashMap<>(), response);

        // Extract Bing-related HTTP headers
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (String header : headers.keySet()) {
            if (header == null) continue;      // may have null key
            if (header.startsWith("BingAPIs-") || header.startsWith("X-MSEdge-")) {
                results.relevantHeaders.put(header, headers.get(header).get(0));
            }
        }
        stream.close();
        scanner.close();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(results.getJsonResponse(), BingWebSearchResponse.class);
    }

}