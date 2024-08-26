package za.ac.cput.novacinemaapp.factory;
//GammaadMohamed
//220208344

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Notification;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void testBuildNotification() {
        Notification n = NotificationFactory.buildNotification("1", "Reminder: Your movie starts in 30 minutes!", "user@example.com");
        assertNotNull(n);
        System.out.println(n.toString());
    }

    @Test
    void testBuildNotificationWithMissingFields() {
        Notification n = NotificationFactory.buildNotification("", "Reminder: Your movie starts in 30 minutes!", "user@example.com");
        assertNull(n); // Expecting null because notificationID is missing
        System.out.println(n);
    }

    @Test
    void testBuildNotificationWithoutID() {
        Notification n = NotificationFactory.buildNotification("Reminder: Your movie starts in 30 minutes!", "user@example.com");
        assertNotNull(n);
        System.out.println(n.toString());
    }
}
