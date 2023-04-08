package com.example.payment_01.controllers;

import com.example.payment_01.dto.CustomerDto;
import com.example.payment_01.dto.TransactionDto;
import com.example.payment_01.dto.TransactionType;
import com.example.payment_01.entities.CustomerEntity;
import com.example.payment_01.entities.TransactionEntity;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.services.CustomerService;
import com.example.payment_01.services.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<TransactionEntity, TransactionDto, TransactionService> {
    @PostMapping("/account")
    public void addA(@RequestBody TransactionDto transactionDto) throws ServiceException {
        transactionDto.setType(TransactionType.ACCOUNT);
        service.insert(convertor.convertDto(transactionDto));
    }

    @Override
    @PostMapping("/card")
    public void add(@RequestBody TransactionDto transactionDto) throws ServiceException {
        transactionDto.setType(TransactionType.CARDTOCARD);
        service.insert(convertor.convertDto(transactionDto));
    }
}
