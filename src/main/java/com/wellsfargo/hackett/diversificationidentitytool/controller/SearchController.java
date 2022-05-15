package com.wellsfargo.hackett.diversificationidentitytool.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wellsfargo.hackett.diversificationidentitytool.business.DiversificationIdentityService;
import com.wellsfargo.hackett.diversificationidentitytool.dataaccess.EventsDAO;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationRequest;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private static final Gson GSON = new GsonBuilder().create();

    @Autowired
    EventsDAO eventsDAO;

    @Autowired
    DiversificationIdentityService diversificationIdentityService;

    @PostMapping("/search")
    public String search(@ModelAttribute DiversificationRequest diversificationRequest, Model model) throws Exception {

        String inputText = diversificationRequest.getInputText().replaceAll(" ", "+");
        DiversificationResponse diversificationResponse = diversificationIdentityService.getDiversityResults(inputText);

        eventsDAO.recordEvents(diversificationRequest.getInputText(),
                GSON.toJson(diversificationResponse));

        model.addAttribute("requestModel", diversificationRequest);
        model.addAttribute("responseModel", diversificationResponse);
        return "diversify_result";
    }

}