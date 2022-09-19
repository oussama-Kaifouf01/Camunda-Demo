package com.example.workflow.Camunda.Services;

import com.example.workflow.Modals.Transaction;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CamundaStartService {
    @Autowired
    RuntimeService runtimeService;

    public List<MessageCorrelationResultWithVariables> startProcessByMessage(Transaction transaction)
    {
        return runtimeService.createMessageCorrelation("newTransaction")
                .setVariable("Id",transaction.getId())
                .setVariable("Amount",transaction.getAmount())
                .setVariable("SenderId",transaction.getSenderId())
                .setVariable("RecipientId",transaction.getRecipientId())
                .setVariable("Signature",transaction.getSignature())
                .correlateAllWithResultAndVariables(true);
    }


}
