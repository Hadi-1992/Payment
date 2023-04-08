package com.example.payment_01.services;

import com.example.payment_01.entities.CustomerEntity;
import com.example.payment_01.entities.accounts.Account;
import com.example.payment_01.entities.accounts.AccountType;
import com.example.payment_01.entities.accounts.Card;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService extends AbstractService<CustomerRepository, CustomerEntity> {


    @Override
    public void insert(CustomerEntity customer) throws ServiceException {

        List<Account> accounts = new ArrayList<>();

        Card c = new Card((long) (Math.random() * 100000000000000L), (long) (Math.random() * 10000 ), getExpireTime());

        Account account = new Account(AccountType.JARI , (long) (Math.random() * 4000000000000L) ,5000000L, customer , c);
        accounts.add(account);

        customer.setAccounts(accounts);

        repository.save(customer);
    }


    public CustomerEntity getById(Long accountId) {

        CustomerEntity c =  repository.findById(accountId).get();
        if (c!= null){

            return c;
        }
        return null;

    }


    private Date getExpireTime(){

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 3);
        return cal.getTime();
    }
}
