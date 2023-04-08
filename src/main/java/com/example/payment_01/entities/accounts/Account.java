package com.example.payment_01.entities.accounts;

import com.example.payment_01.entities.AbstractEntity;
import com.example.payment_01.entities.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Account extends AbstractEntity {
    @Enumerated(value = EnumType.STRING)
    private AccountType type;
    @Column(unique = true)
    private Long accountNumber;
    private Long balance;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToOne(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;
}
