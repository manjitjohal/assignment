package com.serand.assignment.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "jobs")
public class Job {
    @Id
    private String id;
    private String jobId;
    private String companyId;
    private String jobName;
}
