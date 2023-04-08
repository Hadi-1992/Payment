package com.example.payment_01.dto.convertors;

import com.example.payment_01.dto.TransactionDto;
import com.example.payment_01.entities.TransactionEntity;
import com.example.payment_01.entities.accounts.Account;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.services.AccountService;
import com.example.payment_01.services.CustomerService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Mapper(componentModel = "Spring",mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public abstract class TransactionConvertor implements BaseConvertor<TransactionDto, TransactionEntity> {


    @Autowired
    private AccountService accountService;

    @Override
    public abstract TransactionEntity convertDto(TransactionDto transactionDto) throws ServiceException;


    @AfterMapping
    public void setCustomers(@MappingTarget TransactionEntity trx, TransactionDto transactionDto) throws ServiceException {


        switch (transactionDto.getType()) {

            case CARDTOCARD -> {

                Account senderAccount = accountService.getByCardNumber(transactionDto.getSource());
                Account receiverAccount = accountService.getByCardNumber(transactionDto.getDestination());

                trx.setSenderAccount(senderAccount);
                trx.setReceiverAccount(receiverAccount);

            }
            case ACCOUNT -> {

                Account senderAccount = accountService.getByAccountNumber(transactionDto.getSource());
                Account receiverAccount = accountService.getByAccountNumber(transactionDto.getDestination());

                trx.setSenderAccount(senderAccount);
                trx.setReceiverAccount(receiverAccount);

            }
        }
    }

}
