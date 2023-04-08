package com.example.payment_01.controllers.aspects;

import lombok.Data;

@Data
public class LogModel {
    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;
}
