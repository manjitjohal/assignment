package com.serand.assignment.RequestDTO;

package com.serand.assignment.requestdto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Data
public class SurveyResponse {
    private String candidateId;
    private String surveyId;
    Map<String, String> surveyAnswers = new HashMap<String, String>();

}

