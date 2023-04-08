package com.example.payment_01.services;

import com.example.payment_01.entities.TransactionEntity;
import com.example.payment_01.entities.accounts.Account;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.repositories.TransactionRepository;
import com.example.payment_01.services.notifications.NotificationSender;
import com.example.payment_01.services.notifications.NotificationText;
import com.example.payment_01.services.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionService extends AbstractService<TransactionRepository, TransactionEntity> {
    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationSender notificationSender;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void insert(TransactionEntity trx) throws ServiceException {

        Account sender = accountService.withdraw(trx.getSenderAccount(), trx.getAmount());


        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        Account receiver = accountService.deposit(trx.getReceiverAccount(), trx.getAmount());

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }


        trx.setSender(sender.getCustomer());
        trx.setReceiver(receiver.getCustomer());
        trx.setDate(new Date());
        repository.save(trx);


        notificationSender.send(NotificationType.SMS, new NotificationText("Deduction money from your account ", sender.getCard().getCardNumber().toString(), trx.getAmount(), trx.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("addition Money to your account", receiver.getCard().getCardNumber().toString(), trx.getAmount(), trx.getDate()));


    }
}
