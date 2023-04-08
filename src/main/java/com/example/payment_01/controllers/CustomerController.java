package com.example.payment_01.controllers;

import com.example.payment_01.dto.CustomerDto;
import com.example.payment_01.entities.CustomerEntity;
import com.example.payment_01.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<CustomerEntity,CustomerDto, CustomerService> {
}
