package com.example.workflow.Controllers;

import com.example.workflow.Camunda.Services.CamundaStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignatureController {
    @Autowired
    private CamundaStartService camundaStartService;


    public void sendSignature(@RequestBody Map<String, String> body)
    {

    }

}
