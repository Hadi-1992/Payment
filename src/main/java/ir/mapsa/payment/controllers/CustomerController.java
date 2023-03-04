package ir.mapsa.payment.controllers;

import ir.mapsa.payment.entities.Customer;
import ir.mapsa.payment.exceptions.ServiceException;
import ir.mapsa.payment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody Customer customer) {
        customerService.insert(customer);
    }

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) throws ServiceException {
        customerService.getById(id);
    }

    @GetMapping("card/{cardNumber}")
    public Long getBalance(@PathVariable("cardNumber") String card) throws ServiceException {
        return customerService.accountBalance(card);

    }
}
