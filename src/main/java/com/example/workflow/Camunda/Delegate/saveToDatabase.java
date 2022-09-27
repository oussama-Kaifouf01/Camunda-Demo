package com.example.workflow.Camunda.Delegate;

import com.example.workflow.Modals.Transaction;
import com.example.workflow.Repository.TransactionRepoJPA;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class saveToDatabase implements JavaDelegate {

    @Autowired
    TransactionRepoJPA transactionRepoJPA;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Transaction a = new Transaction();
        a.setId(1);
        transactionRepoJPA.save(a);

    }
}
