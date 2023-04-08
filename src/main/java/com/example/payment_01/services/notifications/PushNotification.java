package com.example.payment_01.services.notifications;

public class PushNotification implements Notification{
    @Override
    public void notifyUser(NotificationText text) {

        System.out.println("Push is send .. .  .\n " + text);
    }
}
