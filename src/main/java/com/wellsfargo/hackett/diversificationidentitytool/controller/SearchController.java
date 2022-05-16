package com.wellsfargo.hackett.diversificationidentitytool.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wellsfargo.hackett.diversificationidentitytool.business.DiversificationIdentityService;
import com.wellsfargo.hackett.diversificationidentitytool.dataaccess.EventsDAO;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationRequest;
import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;

@Controller
public class SearchController {

	private static final Gson GSON = new GsonBuilder().create();

	private static final Log LOG = LogFactory.getLog(SearchController.class);

	@Autowired
	EventsDAO eventsDAO;

	@Autowired
	DiversificationIdentityService diversificationIdentityService;

	@PostMapping("/search")
	public String search(@ModelAttribute DiversificationRequest diversificationRequest, Model model) throws Exception {
		if (StringUtils.isEmpty(diversificationRequest.getInputText())) {
			model.addAttribute("requestModel", diversificationRequest);
			return "diversify";
		}
		
		try {
			String inputText = diversificationRequest.getInputText().replaceAll(" ", "+");
			DiversificationResponse diversificationResponse = diversificationIdentityService
					.getDiversityResults(inputText);

			eventsDAO.recordEvents(diversificationRequest.getInputText(), GSON.toJson(diversificationResponse));

			model.addAttribute("requestModel", diversificationRequest);
			model.addAttribute("responseModel", diversificationResponse);
			return "diversify_result";
		} catch (Exception ex) {
			LOG.error("error searching for the given input: " + diversificationRequest.getInputText(), ex);
			return "error";
		}
	}

}