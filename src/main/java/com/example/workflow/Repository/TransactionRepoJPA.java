package com.example.workflow.Repository;

import com.example.workflow.Modals.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepoJPA extends JpaRepository<Transaction,Integer> {

}
