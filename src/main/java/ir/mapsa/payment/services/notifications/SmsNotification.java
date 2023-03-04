package ir.mapsa.payment.services.notifications;

public class SmsNotification implements Notification{
    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("sms is sent\n"+text);
    }
}
