package com.example.payment_01.repositories;

import com.example.payment_01.entities.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCard_CardNumber(String card);

    Account findByAccountNumber(String accountNumber);
}
