package com.serand.assignment.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;
    private String name;

    private String candidates;
}
