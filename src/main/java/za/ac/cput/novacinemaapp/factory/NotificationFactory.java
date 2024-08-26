package za.ac.cput.novacinemaapp.factory;

/*
GammaadMohamed-220208344
 */

import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.util.Helper;

public class NotificationFactory {
    public static Notification buildNotification(String description, User user) {
        if (Helper.isNullOrEmpty(description) || user == null)
            return null;

        return new Notification.Builder()
                .setNotificationID(Helper.generateId())
                .setDescription(description)
                .setUser(user)
                .build();
    }
}
