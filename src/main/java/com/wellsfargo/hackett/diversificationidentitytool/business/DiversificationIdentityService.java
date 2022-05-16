package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiversificationIdentityService {

    @Autowired
    BingWebSearchService bingWebSearchService;

    @Autowired
    ScrapingService scrapingService;

    public DiversificationResponse getDiversityResults(String inputText) throws Exception {

        BingWebSearchResponse bingWebSearchResponse = bingWebSearchService.searchWeb(inputText);

        return scrapingService.scrapeSearchResults(bingWebSearchResponse);
    }

}
