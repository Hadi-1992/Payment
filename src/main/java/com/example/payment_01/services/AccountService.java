package com.example.payment_01.services;

import com.example.payment_01.entities.accounts.Account;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<AccountRepository, Account> {
    public Account withdraw(Account c, Long amount) throws ServiceException {

        if (c != null && amount < c.getBalance()) {

            c.setBalance(c.getBalance() - amount);
            repository.save(c);

            return c;

        }
        return null;
    }

    public Account deposit(Account c, Long amount) throws ServiceException {

        if (c != null) {

            c.setBalance(c.getBalance() + amount);
            repository.save(c);
            return c;

        }
        return null;
    }

    public Account getByCardNumber(String cardNumber) {


        return repository.findByCard_CardNumber(cardNumber);

    }

    public Account getByAccountNumber(String accountNumber) {


        return repository.findByAccountNumber(accountNumber);

    }
}
