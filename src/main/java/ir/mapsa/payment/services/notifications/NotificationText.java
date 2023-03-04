package ir.mapsa.payment.services.notifications;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Data
public class NotificationText {
    private String cardNumber;
    private Long amount;
    private Date date;

}
