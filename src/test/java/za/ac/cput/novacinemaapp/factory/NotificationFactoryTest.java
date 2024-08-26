package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void testBuildNotification() {
        User user = new User();
        Notification notification = NotificationFactory.buildNotification("Your movie starts in 30 minutes", user);
        assertNotNull(notification);
        System.out.println(notification.toString());
    }

    @Test
    void testBuildNotificationWithFail() {
        User user = null;
        Notification notification = NotificationFactory.buildNotification("Your movie starts in 30 minutes", user);
        assertNull(notification);
    }
}
