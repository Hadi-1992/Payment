package ir.mapsa.payment.services.notifications;

public class PushNotification implements Notification{
    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("push is sent\n"+text);
    }
}
