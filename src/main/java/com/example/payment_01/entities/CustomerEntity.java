package com.example.payment_01.entities;

import com.example.payment_01.entities.accounts.Account;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class CustomerEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TransactionEntity> transactionList;
}
