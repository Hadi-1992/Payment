package com.example.payment_01.entities.accounts;

import com.example.payment_01.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card extends AbstractEntity {
    @Column(unique = true)
    private Long cardNumber;
    private Long cvv2;
    private Date date;

}
