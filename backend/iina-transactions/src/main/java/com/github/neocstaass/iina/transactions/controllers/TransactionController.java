package com.github.neocstaass.iina.transactions.controllers;


import com.github.neocstaass.iina.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("get-transaction-info")
    public String getEventInfo(@RequestParam("id") String eventID) {
        return String.format("Info of transaction %s", eventID);
    }
}
