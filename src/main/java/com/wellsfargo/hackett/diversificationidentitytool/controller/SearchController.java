package com.wellsfargo.hackett.diversificationidentitytool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wellsfargo.hackett.diversificationidentitytool.dataaccess.EventsDAO;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationRequest;

@Controller
public class SearchController {

  @Autowired
  EventsDAO eventsDAO;

  @PostMapping("/search")
  public String search(@ModelAttribute DiversificationRequest diversificationRequest,
      Model model) {

    diversificationRequest.setOutputText("Success");
    eventsDAO.recordEvents(diversificationRequest.getInputText(),
        diversificationRequest.getOutputText());

    model.addAttribute("requestModel", diversificationRequest);
    return "result";
  }
}