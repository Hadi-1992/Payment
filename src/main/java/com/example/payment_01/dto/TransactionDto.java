package com.example.payment_01.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Long id;
    private String source;
    private String destination;
    private Long amount;
    private TransactionType type;
}
