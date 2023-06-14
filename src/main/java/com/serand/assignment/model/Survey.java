package com.serand.assignment.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "surveys")
public class Survey {
    @Id
    private String id;
    private String name;

    Map<String, String> surveyQuestions = new HashMap<String, String>();

}
