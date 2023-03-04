package ir.mapsa.payment.services;

import ir.mapsa.payment.entities.Customer;
import ir.mapsa.payment.exceptions.ServiceException;
import ir.mapsa.payment.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void insert(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getById(Long id) throws ServiceException {
        Optional<Customer> customer = customerRepository.findById(id);
        try {
            return customer.orElseThrow();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), "User not found");
        }


    }
    public Long accountBalance(String cardNumber) throws ServiceException {
      Customer customer = customerRepository.findByCardNumber(cardNumber);
        if (customer != null) {
            return customer.getBalance();
        }else {
            throw new ServiceException("User not found");
        }
    }

}
