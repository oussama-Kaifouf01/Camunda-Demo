package com.example.workflow.Controllers;

import com.example.workflow.Camunda.Services.CamundaFormService;
import com.example.workflow.Camunda.Services.CamundaStartService;
import com.example.workflow.Modals.Transaction;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {
    @Autowired
    private CamundaStartService camundaStartService;
    private CamundaFormService camundaFormService;

    @RequestMapping(value="/user/transaction",method = RequestMethod.POST)
    public void newTransaction(@RequestBody Transaction transaction)
    {
        List<MessageCorrelationResultWithVariables> result =camundaStartService.startProcessByMessage(transaction);

    }

    @RequestMapping(value="/faxManager/signature",method = RequestMethod.POST)
    public void faxManager(@RequestBody Map<String, String> body)
    {
        String businessKey = body.get("businessKey");



    }


}
