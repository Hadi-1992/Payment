package com.example.payment_01.entities;

import com.example.payment_01.entities.accounts.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Entity
@Data
public class TransactionEntity extends AbstractEntity{
    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private CustomerEntity sender;
    @OneToOne
    private Account senderAccount;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private CustomerEntity receiver;
    @OneToOne
    private Account receiverAccount;
    private Long amount;
}
