package com.example.payment_01.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private boolean error;
    private String message;
}
