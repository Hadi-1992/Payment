package com.example.payment_01.dto;

import com.example.payment_01.entities.accounts.Account;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
//    private List<Account> accounts;
    private Long balance;
}
