package za.ac.cput.novacinemaapp.factory;

/*
gammaad mohamed
220208344
 */

import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.util.Helper;

public class NotificationFactory {
    public static Notification buildNotification(String notificationID, String message, String recipient) {
        if (Helper.isNullOrEmpty(notificationID) || Helper.isNullOrEmpty(message) || Helper.isNullOrEmpty(recipient))
            return null;

        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setMessage(message)
                .setRecipient(recipient)
                .build();
    }

    public static Notification buildNotification(String message, String recipient) {
        if (Helper.isNullOrEmpty(message) || Helper.isNullOrEmpty(recipient))
            return null;

        String notificationID = Helper.generateId();

        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setMessage(message)
                .setRecipient(recipient)
                .build();
    }
}
