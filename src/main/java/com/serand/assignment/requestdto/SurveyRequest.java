package com.serand.assignment.requestdto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Data
public class SurveyRequest {
    private String companyId;
    private String name;
    Map<String, String> surveyQuestions = new HashMap<String, String>();

}
