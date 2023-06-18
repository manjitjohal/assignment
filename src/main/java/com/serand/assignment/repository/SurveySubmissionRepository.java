package com.serand.assignment.repository;

import com.serand.assignment.model.SurveySubmission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveySubmissionRepository extends MongoRepository<SurveySubmission, String> {

    Optional<SurveySubmission> findById(String id);

}