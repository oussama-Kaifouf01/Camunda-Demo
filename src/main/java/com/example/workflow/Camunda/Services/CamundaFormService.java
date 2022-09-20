package com.example.workflow.Camunda.Services;

import org.camunda.bpm.engine.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaFormService {

    @Autowired
    private FormService formService;

    public String setSignatureRequiredAndCompleteTask(String id,boolean isSigRequired)
    {
        Map<String, Object> variables = new HashMap<>() ;
        variables.put("isSigRequired", isSigRequired);

        formService.submitTaskForm(id,variables ); ;

        return "task Complete";
    }
}
