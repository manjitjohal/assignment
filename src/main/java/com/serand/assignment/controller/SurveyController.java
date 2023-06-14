package com.serand.assignment.controller;


import com.serand.assignment.model.Survey;
import com.serand.assignment.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Responsible for all user related endpoints.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/surveys")
public class SurveyController {


	@Autowired
	private SurveyRepository surveyRepository;

	@GetMapping("/company/{companyId}")
	public List<Survey> getSurveysByCompanyId(@PathVariable("companyId") String companyId) {
		return surveyRepository.findByCompanyId(companyId);
	}

}