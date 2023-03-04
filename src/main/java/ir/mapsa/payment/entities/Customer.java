package ir.mapsa.payment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Data
public class Customer extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private Integer age;
    private Long balance;

}