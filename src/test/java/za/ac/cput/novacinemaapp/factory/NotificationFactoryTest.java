package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void testBuildNotification() {
        User b = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!");
        Notification notification = NotificationFactory.buildNotification("1","Your movie starts in 30 minutes", b);
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    void testBuildNotificationWithFail() {
        User b = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!");
        Notification notification = NotificationFactory.buildNotification("3","", b);
        assertNotNull(notification);
        System.out.println(notification);
    }
}
