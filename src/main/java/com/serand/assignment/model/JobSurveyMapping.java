package com.serand.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class JobSurveyMapping {
    @Id
    private String id;
    private String surveyId;
    private String jobId;
}
