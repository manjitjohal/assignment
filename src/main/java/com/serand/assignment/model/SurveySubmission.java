package com.serand.assignment.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document
public class SurveySubmission {
    @Id
    private String id;
    private String candidateId;
    private String surveyId;
    private String jobId;
    private int score=-1;
    List<String> surveyAnswers = new ArrayList<String>();
}
