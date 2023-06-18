package com.serand.assignment.requestdto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SurveyResponse {
    private String candidateId;
    private String surveyId;
    private String jobId;
    List<String> surveyAnswers = new ArrayList<String>();
}
