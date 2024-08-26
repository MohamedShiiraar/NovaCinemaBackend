package za.ac.cput.novacinemaapp.factory;

/*
NotificationFactory.java
Entity for Notification factory
Author: [Your Name] ([Your Student ID])
Date: [Current Date]
 */

import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.util.Helper;

public class NotificationFactory {

    public static Notification buildNotification(String description, User user) {
        if (Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(user))
            return null;

        String notificationID = Helper.generateId();
        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setDescription(description)
                .setUser(user)
                .build();
    }

    public static Notification buildNotification(String notificationID, String description, User user) {
        if (Helper.isNullOrEmpty(notificationID) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(user))
            return null;

        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setDescription(description)
                .setUser(user)
                .build();
    }
}
