package com.example.payment_01.controllers.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.http.HttpClient;

@Aspect
@Component
@Slf4j
public class ControllerAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ObjectMapper objectMapper;

    @Before("within(com.example.payment_01.controllers.AbstractController+)")
    public void before() {
        log.info("Request coming from: " + request.getServerName()
                + "\nAND their IP: " + request.getLocalAddr()
                + "\nAND call URL: " + request.getRequestURI());
    }

        @Around("within(com.example.payment_01.controllers.AbstractController+)")
                public void around(ProceedingJoinPoint joinPoint)throws Throwable{
            LogModel logModel = new LogModel();
            logModel.setMethodName(joinPoint.getSignature().getName());

            logModel.setRequest(joinPoint.getArgs() );

            Object value;
            try {
                value = joinPoint.proceed();
                if (value !=null){
                    logModel.setResponse(value);
                }
                log.info("Success req" + objectMapper.writeValueAsString(logModel));
            } catch (Throwable e) {


                StringWriter writer = new StringWriter();
                PrintWriter printWriter = new PrintWriter(writer);
                e.printStackTrace(printWriter);
                writer.close();
                printWriter.close();
                logModel.setErrorTrace(writer.toString());
                log.error("Failure req " + objectMapper.writeValueAsString(logModel));
                throw e;

            }

        }
}
