package ir.mapsa.payment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Transaction extends AbstractEntity{

    private Date date;
    private String senderCardNumber;
    private String receiverCardNumber;
    private Long amount;

}
