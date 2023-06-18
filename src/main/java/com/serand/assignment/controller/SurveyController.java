package com.serand.assignment.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.serand.assignment.model.Survey;
import com.serand.assignment.model.SurveySubmission;
import com.serand.assignment.repository.SurveyRepository;
import com.serand.assignment.repository.SurveySubmissionRepository;
import com.serand.assignment.requestdto.SurveyRequest;
import com.serand.assignment.requestdto.SurveyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Responsible for all user related endpoints.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/api/surveys")
public class SurveyController {


	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private SurveySubmissionRepository surveySubmissionRepository;

	@GetMapping("/company")
	public List<Survey> getSurveys() {
		return surveyRepository.findAll();
	}

	@GetMapping("/company/{companyId}")
	public List<Survey> getSurveysByCompanyId(@PathVariable("companyId") String companyId) {
		return surveyRepository.findByCompanyId(companyId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/company", produces = { "application/json" })
	public void postSurveysByCompanyId(@RequestBody SurveyRequest surveyRequest) {
		Survey survey = new Survey();
		survey.setCompanyId(surveyRequest.getCompanyId());
		survey.setName(surveyRequest.getName());
		survey.setSurveyQuestions(surveyRequest.getSurveyQuestions());
		surveyRepository.insert(survey);
	}

	@DeleteMapping("/company/{companyId}")
	public void deleteSurveysByCompanyId(@PathVariable("companyId") String companyId) {
		surveyRepository.deleteByCompanyId(companyId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/submit", produces = { "application/json" })
	public String postSurveysByCompanyId(@RequestBody SurveyResponse surveyResponse) {
		SurveySubmission surveySubmission = new SurveySubmission();
		surveySubmission.setCandidateId(surveyResponse.getCandidateId());
		surveySubmission.setSurveyAnswers(surveyResponse.getSurveyAnswers());
		surveySubmission.setSurveyId(surveyResponse.getSurveyId());
		surveySubmission.setJobId(surveyResponse.getJobId());
		return surveySubmissionRepository.insert(surveySubmission).getId();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/score/{surveySubmissionId}", produces = { "application/json" })
	public int postSurveysByCompanyId(@PathVariable("surveySubmissionId") String surveySubmissionId) {
		Optional<SurveySubmission> surveySubmission = surveySubmissionRepository.findById(surveySubmissionId);
		String surveyId = null;
		int count=0;
		if(surveySubmission.isPresent()){
			List<String> surveyAnswers = surveySubmission.get().getSurveyAnswers();
			surveyId = surveySubmission.get().getSurveyId();
			Object[] surveyExpectedAnswers = surveyRepository.findById(surveyId).get().getSurveyQuestions().values().toArray();
			for(int i=0;i<surveyAnswers.size();i++){
				String answer = (String) surveyExpectedAnswers[i];
				if(answer.equalsIgnoreCase(surveyAnswers.get(i)))
					count++;
			}
			surveySubmission.get().setScore(count);
			return surveySubmissionRepository.save(surveySubmission.get()).getScore();
		}
		return -1;
	}
}