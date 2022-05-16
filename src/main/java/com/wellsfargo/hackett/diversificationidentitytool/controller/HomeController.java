package com.wellsfargo.hackett.diversificationidentitytool.controller;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String homePage(Model model) {

    model.addAttribute("requestModel", new DiversificationRequest());
    return "diversify";
  }
}