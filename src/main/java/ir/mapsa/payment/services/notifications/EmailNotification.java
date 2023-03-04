package ir.mapsa.payment.services.notifications;

import ir.mapsa.payment.services.notifications.Notification;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("email is sent\n"+text);
    }
}
