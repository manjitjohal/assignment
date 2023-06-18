package com.serand.assignment.repository;

import com.serand.assignment.model.Job;
import com.serand.assignment.model.JobSurveyMapping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSurveyMappingRepository extends MongoRepository<JobSurveyMapping, String> {

}