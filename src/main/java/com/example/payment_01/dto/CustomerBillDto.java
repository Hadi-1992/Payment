package com.example.payment_01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBillDto {
    private Long id;
    private Long payId;
    private Long mobileNum;
    private String customerName;
    private Long dept;
    private Date dueDate;
}
