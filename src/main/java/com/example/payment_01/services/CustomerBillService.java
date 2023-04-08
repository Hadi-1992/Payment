package com.example.payment_01.services;

import com.example.payment_01.entities.CustomerBill;
import com.example.payment_01.repositories.CustomerBillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CustomerBillService extends AbstractService<CustomerBillRepository, CustomerBill> {
    public CustomerBill getBill(Long number) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomerBill> billResponseEntity = restTemplate.getForEntity("http://localhost:8081/bill/" + number, CustomerBill.class);
        if (billResponseEntity.getStatusCode().is2xxSuccessful()) {
            repository.save(Objects.requireNonNull(billResponseEntity.getBody()));
            System.out.println(billResponseEntity.getBody());
            return billResponseEntity.getBody();
        } else {

            return null;
        }


    }
}
