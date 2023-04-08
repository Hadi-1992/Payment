package com.example.payment_01.controllers;

import com.example.payment_01.dto.convertors.BaseConvertor;
import com.example.payment_01.dto.convertors.CustomerBillConverter;
import com.example.payment_01.entities.CustomerBill;
import com.example.payment_01.dto.CustomerBillDto;
import com.example.payment_01.services.CustomerBillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class CustomerBillController extends AbstractController<CustomerBill,CustomerBillDto,CustomerBillService> {
   @GetMapping("/{number}")
    public CustomerBillDto getBill(@PathVariable("number") Long num) {

        return convertor.convertEntity(service.getBill(num));
    }
}
