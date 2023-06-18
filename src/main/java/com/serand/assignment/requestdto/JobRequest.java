package com.serand.assignment.requestdto;

import lombok.Data;

import java.util.List;

@Data
public class JobRequest {
    private String jobId;
    private String companyId;
    private String name;
    private List<String> surveyIds;
}
