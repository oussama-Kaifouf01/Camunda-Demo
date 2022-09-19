package com.example.workflow.Controllers;

import com.example.workflow.Camunda.Services.CamundaStartService;
import com.example.workflow.Modals.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class TransactionController {
    @Autowired
    private CamundaStartService camundaStartService;

    @RequestMapping(value="/add/user",method = RequestMethod.POST)
    public void addUser(@RequestBody Transaction transaction)
    {
        camundaStartService.startProcessByMessage(transaction);

    }


}
