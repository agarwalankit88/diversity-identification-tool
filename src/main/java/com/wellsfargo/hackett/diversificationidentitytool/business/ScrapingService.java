package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import com.wellsfargo.hackett.diversificationidentitytool.model.SourceData;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import me.xdrop.fuzzywuzzy.FuzzySearch;
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

    private static final List<String> leaderShipStandardKeywords = Arrays.asList("Leadership", "Executive", "CEO", "CTO",
            "Director", "Board of Directors", "Senior leadership", "Committees", "Governance", "management team", "executive team");

    private static final List<String> buyersStandardKeywords = Arrays.asList("Buyer", "Customer", "Client", "consumer");

    public DiversificationResponse scrapeSearchResults(BingWebSearchResponse bingWebSearchResponse) {

        DiversificationResponse response = new DiversificationResponse();
        Optional.ofNullable(bingWebSearchResponse).map(bingWebSearchResponse1 -> bingWebSearchResponse1.getWebPages().getValue())
                .map(values -> {
                    Map<String, SourceData> map = new LinkedHashMap<>();
                    values.forEach(value -> map.put(value.getUrl(),
                            new SourceData(value.getSnippet(), scrapWebPage(value.getUrl(),
                                    bingWebSearchResponse.getQueryContext().getOriginalQuery()))));
                    response.setResponse(map);
                    return null;
                });
        return response;
    }

    public List<String> scrapWebPage(String baseURL, String inputText) {

        List<String> finalList = getFinalListOfStrings(inputText);
        List<String> finalScrapedList = new ArrayList<>();
        Optional.ofNullable(baseURL).map(this::getDocument).ifPresent(document -> {
            finalList.stream().forEach(keyword -> {
                Optional.ofNullable(getElements(document, keyword)).
                        ifPresent(elements -> elements.stream().forEach(element -> finalScrapedList.add(element.html())));
            });

        });

        return finalScrapedList;
    }

    private List<String> getFinalListOfStrings(String inputText) {

        List<String> finalList = new ArrayList<>();
        List<String> inputArray = List.of(inputText.split("\\+"));

        boolean lkw = false;
        boolean bkw = false;
        for (String input : inputArray
        ) {
            for (String key : leaderShipStandardKeywords) {
                int n = FuzzySearch.ratio(input, key);
                if (n > 50) {
                    lkw = true;
                }
            }


            for (String key : buyersStandardKeywords) {
                int n = FuzzySearch.ratio(input, key);
                if (n > 50) {
                    bkw = true;
                }
            }
        }
        if (lkw) {
            finalList.addAll(leaderShipStandardKeywords);
        }
        if (bkw) {
            finalList.addAll(buyersStandardKeywords);
        }
        return finalList;
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
