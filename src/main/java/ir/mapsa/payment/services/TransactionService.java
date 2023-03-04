package ir.mapsa.payment.services;

import ir.mapsa.payment.entities.Customer;
import ir.mapsa.payment.entities.Transaction;
import ir.mapsa.payment.exceptions.ServiceException;
import ir.mapsa.payment.repositories.CustomerRepository;
import ir.mapsa.payment.repositories.TransactionRepository;
import ir.mapsa.payment.services.notifications.NotificationSender;
import ir.mapsa.payment.services.notifications.NotificationText;
import ir.mapsa.payment.services.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;

    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(Transaction transaction) throws ServiceException {
        Customer wDrw = withdraw(transaction.getSenderCardNumber(), transaction.getAmount());
        if (wDrw.equals(null)) {
            throw new ServiceException("Your balance is not enough");
        }
        Customer dPosit = deposit(transaction.getReceiverCardNumber(), transaction.getAmount());
        if (dPosit.equals(null)) {

            throw new ServiceException("Receiver card number is not valid");
        }
        transactionRepository.save(transaction);
        notificationSender.send(NotificationType.SMS,new  NotificationText(wDrw.getCardNumber(),transaction.getAmount(),transaction.getDate()));
        notificationSender.send(NotificationType.EMAIL,new  NotificationText(dPosit.getCardNumber(),transaction.getAmount(),transaction.getDate()));

    }

    private Customer withdraw(String cardNumber, Long amount) {
        Customer customer = customerRepository.findByCardNumber(cardNumber);
        if (amount < customer.getBalance()) {
            customer.setBalance(customer.getBalance() - amount);
            customerRepository.save(customer);
            return customer;
        }
        return null;
    }

    private Customer deposit(String cardNumber, Long amount) {
        Customer customer = customerRepository.findByCardNumber(cardNumber);
        if (customer != null) {
            customer.setBalance(customer.getBalance() + amount);
            customerRepository.save(customer);
            return customer;
        }
        return null;
    }

    public void getTransactions(String cardNumber, Date start, Date end) {
        List<Transaction> transactions = transactionRepository.findBySenderCardNumberAndDateBetween(cardNumber, start, end);
        System.out.println(transactions);
    }

}