package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Service
public class ScrapingService {

    private static final List<String> standardKeywords = Arrays.asList("Leadership", "Executive", "CEO", "CTO", "Chief", "Directors", "Board");

    public DiversificationResponse scrapeSearchResults(BingWebSearchResponse bingWebSearchResponse) {

        DiversificationResponse response = new DiversificationResponse();
        AtomicInteger count = new AtomicInteger(1);
        Optional.ofNullable(bingWebSearchResponse).map(bingWebSearchResponse1 -> bingWebSearchResponse1.getWebPages().getValue())
                .map(values -> {
                    Map<String, List<String>> map = new HashMap<>();
                    values.forEach(value -> map.put("url" + count.getAndIncrement(), scrapWebPage(value.getUrl())));
                    response.setResponse(map);
                    return null;
                });
        return response;
    }

    public List<String> scrapWebPage(String baseURL) {

        List<String> leadershipList = new ArrayList<>();
        Optional.ofNullable(baseURL).map(this::getDocument).ifPresent(document -> {
            standardKeywords.stream().forEach(keyword -> {
                Optional.ofNullable(getElements(document, keyword)).
                        ifPresent(elements -> elements.stream().forEach(element -> leadershipList.add(element.html())));
            });

        });

        /*Document document = getDocument(baseURL);
        if (document != null) {
            for (String keyword : standardKeywords) {
                Elements elements = getElements(document, keyword);
                if (elements != null) {
                    for (Element element : elements) {
                        leadershipList.add(element.html());
                    }
                }
            }
        }*/
        return leadershipList;
    }

    private Document getDocument(String baseURL) {
        try {
            return Jsoup.connect(baseURL).get();
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
        return null;
    }

    private Elements getElements(Document document, String searchKeyword) {
        return document.select(new Evaluator.MatchesOwn(Pattern.compile(searchKeyword)));
    }
}
