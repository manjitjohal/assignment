package com.serand.assignment.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "surveys")
public class Survey {
    @Id
    private String id;
    private String companyId;
    private String name;
    Map<String, String> surveyQuestions = new HashMap<String, String>();

}
