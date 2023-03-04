package ir.mapsa.payment.controllers;

import ir.mapsa.payment.entities.Transaction;
import ir.mapsa.payment.exceptions.ServiceException;
import ir.mapsa.payment.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/print")
    public void addTransaction(@RequestBody Transaction transaction) throws ServiceException {
        transaction.setDate(new Date());
        transactionService.resolveTransaction(transaction);
    }
}