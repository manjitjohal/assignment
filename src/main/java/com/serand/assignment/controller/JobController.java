package com.serand.assignment.controller;


import com.serand.assignment.model.Job;
import com.serand.assignment.model.JobApplication;
import com.serand.assignment.model.JobSurveyMapping;
import com.serand.assignment.model.Survey;
import com.serand.assignment.repository.JobApplicationRepository;
import com.serand.assignment.repository.JobRepository;
import com.serand.assignment.repository.JobSurveyMappingRepository;
import com.serand.assignment.requestdto.JobApplicationRequest;
import com.serand.assignment.requestdto.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Responsible for all user related endpoints.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/api")
public class JobController {


	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private JobSurveyMappingRepository jobSurveyMappingRepository;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@GetMapping("/jobs")
	public List<Job> getJobs() {
		return jobRepository.findAll();
	}

	@GetMapping("/jobs/{companyId}")
	public List<Job> getJobsByCompanyId(@PathVariable("companyId") String companyId) {
		return jobRepository.findByCompanyId(companyId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jobs", produces = { "application/json" })
	public void postSurveysByCompanyId(@RequestBody JobRequest jobRequest) {
		Job job = new Job();
		List<JobSurveyMapping> jobSurveyMappings = new ArrayList<JobSurveyMapping>();
		job.setCompanyId(jobRequest.getCompanyId());
		job.setJobName(jobRequest.getName());
		job.setJobId(jobRequest.getJobId());
		jobRepository.insert(job);
		jobRequest.getSurveyIds().forEach(surveyId->{
			JobSurveyMapping jobSurveyMapping = new JobSurveyMapping();
			jobSurveyMapping.setSurveyId(surveyId);
			jobSurveyMapping.setJobId(jobRequest.getJobId());
			jobSurveyMappings.add(jobSurveyMapping);
		});
		jobSurveyMappingRepository.insert(jobSurveyMappings);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jobs/apply", produces = { "application/json" })
	public String postSurveysByCompanyId(@RequestBody JobApplicationRequest jobApplicationRequest) {
		JobApplication jobApplication = new JobApplication();
		jobApplication.setJobId(jobApplicationRequest.getJobId());
		jobApplication.setCandidateId(jobApplication.getCandidateId());
		return jobApplicationRepository.insert(jobApplication).getId();
	}
}