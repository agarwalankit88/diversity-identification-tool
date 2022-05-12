package com.wellsfargo.hackett.diversificationidentitytool.controller;

import com.wellsfargo.hackett.diversificationidentitytool.business.BingWebSearchService;
import com.wellsfargo.hackett.diversificationidentitytool.business.SearchResults;
import com.wellsfargo.hackett.diversificationidentitytool.dataaccess.EventsDAO;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @Autowired
    EventsDAO eventsDAO;

    @Autowired
    BingWebSearchService bingWebSearchService;

    @PostMapping("/search")
    public String search(@ModelAttribute DiversificationRequest diversificationRequest,
                         Model model) throws Exception {

        String inputText = diversificationRequest.getInputText().replaceAll(" ", "+");
        SearchResults searchResults = bingWebSearchService.SearchWeb(inputText);
        diversificationRequest.setOutputText(searchResults.getJsonResponse());
        /*eventsDAO.recordEvents(diversificationRequest.getInputText(),
                diversificationRequest.getOutputText());*/
        //needs to increase the output text column size

        model.addAttribute("requestModel", diversificationRequest);
        return "result";
    }

}