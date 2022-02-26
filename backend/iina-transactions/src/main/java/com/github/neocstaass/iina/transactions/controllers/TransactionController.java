package com.github.neocstaass.iina.transactions.controllers;


import com.github.neocstaass.iina.models.Transaction;
import com.github.neocstaass.iina.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm");

    private static boolean isValid(Transaction transaction) {
        return transaction.getEventID() != null &&
                transaction.getEventID() != -1 &&
                transaction.getCreditorID() != null &&
                transaction.getCreditorID() != -1 &&
                transaction.getDebtorID() != null &&
                transaction.getDebtorID() != -1 &&
                transaction.getValue() != null &&
                transaction.getValue() > 0;
    }

    private static void fillMissingFields(Transaction transaction) {
        if (transaction.getDate() == null) {
            Date date = Calendar.getInstance().getTime();
            transaction.setDate(DATE_FORMAT.format(date));
        }

        if (transaction.getCurrency() == null)
            transaction.setCurrency("EUR");

        boolean isCreditorUser = false;
        if (isCreditorUser)
            transaction.setStatus(Transaction.Status.WAITING);
        else
            transaction.setStatus(Transaction.Status.CREATED);
    }

    @GetMapping("get-transaction")
    public Transaction get(@RequestParam Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return optionalTransaction.get();
    }

    @PostMapping("add-transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction add(@RequestBody Transaction transaction) {
        transaction.setId(-1L);
        if (!isValid(transaction))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        fillMissingFields(transaction);
        transaction = transactionRepository.save(transaction);
        return transaction;
    }

    @PostMapping("update-transaction")
    @ResponseStatus(HttpStatus.OK)
    public Transaction update(@RequestBody Transaction transaction) {
        if (!isValid(transaction))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        transaction = this.transactionRepository.save(transaction);
        return transaction;
    }

    @PostMapping("edit-details")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction editDetails(@RequestParam Long id, @RequestParam String details) {
        Transaction transaction;
        try {
            transaction = transactionRepository.getById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        transaction.setDetails(details);
        transaction = transactionRepository.save(transaction);
        return transaction;
    }

    @PostMapping("change-image")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction changeImage(@RequestParam Long id, @RequestParam(name = "image-url") String imageUrl) {
        Transaction transaction;
        try {
            transaction = transactionRepository.getById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        transaction.setImageUrl(imageUrl);
        transaction = transactionRepository.save(transaction);
        return transaction;
    }
}
