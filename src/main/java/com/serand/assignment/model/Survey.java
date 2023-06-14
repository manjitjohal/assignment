package com.serand.assignment.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "surveys")
public class Survey {
    @Id
    private String id;
    private String name;

}
