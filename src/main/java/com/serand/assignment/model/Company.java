package com.serand.assignment.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "companies")
public class Company {
    @Id
    private String id;
    private String name;
    // Other company properties, getters, and setters
}
