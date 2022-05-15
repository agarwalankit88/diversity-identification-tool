package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import com.wellsfargo.hackett.diversificationidentitytool.model.SourceData;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class ScrapingService {

    private static final List<String> leaderShipStandardKeywords = Arrays.asList("Leadership", "Executive", "CEO", "CTO", "Chief", "Directors", "Board");

    public DiversificationResponse scrapeSearchResults(BingWebSearchResponse bingWebSearchResponse) {

        DiversificationResponse response = new DiversificationResponse();
        Optional.ofNullable(bingWebSearchResponse).map(bingWebSearchResponse1 -> bingWebSearchResponse1.getWebPages().getValue())
                .map(values -> {
                    Map<String, SourceData> map = new TreeMap<>();
                    values.forEach(value -> map.put(value.getUrl(),
                            new SourceData(value.getSnippet(), scrapWebPage(value.getUrl(),
                                    bingWebSearchResponse.getQueryContext().getOriginalQuery()))));
                    response.setResponse(map);
                    return null;
                });
        return response;
    }

    public List<String> scrapWebPage(String baseURL, String inputText) {

        List<String> leadershipList = new ArrayList<>();
        Optional.ofNullable(baseURL).map(this::getDocument).ifPresent(document -> {
            leaderShipStandardKeywords.stream().forEach(keyword -> {
                Optional.ofNullable(getElements(document, keyword)).
                        ifPresent(elements -> elements.stream().forEach(element -> leadershipList.add(element.html())));
            });
            /*Optional.ofNullable(getElements(document, inputText)).
                    ifPresent(elements -> elements.stream().forEach(element -> leadershipList.add(element.html())));*/

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
