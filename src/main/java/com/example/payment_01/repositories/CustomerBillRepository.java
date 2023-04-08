package com.example.payment_01.repositories;

import com.example.payment_01.entities.CustomerBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerBillRepository extends JpaRepository<CustomerBill,Long> {
    CustomerBill findByMobileNum (Long num);
}
