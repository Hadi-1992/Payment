package ir.mapsa.payment.services.notifications;

import org.springframework.stereotype.Service;

@Service
public class NotificationSender {
    public void send(NotificationType type,NotificationText text){
        switch (type){
            case SMS -> new SmsNotification().notifyUser(text);
            case PUSH -> new PushNotification().notifyUser(text);
            case EMAIL -> new EmailNotification().notifyUser(text);
        }
    }
}
