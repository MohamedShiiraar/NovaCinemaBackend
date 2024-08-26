package za.ac.cput.novacinemaapp.service;

/*
GammaadMohamed
220208344
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.factory.NotificationFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    private static Notification notification1, notification2;

    @Test
    @Order(1)
    void setup() {
        notification1 = NotificationFactory.buildNotification("1", "Reminder: Your movie starts in 30 minutes!", "user@example.com");
        assertNotNull(notification1);
        System.out.println(notification1);

        notification2 = NotificationFactory.buildNotification("2", "Your reservation has been confirmed.", "user@example.com");
        assertNotNull(notification2);
        System.out.println(notification2);
    }

    @Test
    @Order(2)
    void create() {
        Notification create1 = notificationService.create(notification1);
        assertNotNull(create1);
        System.out.println(create1);

        Notification create2 = notificationService.create(notification2);
        assertNotNull(create2);
        System.out.println(create2);
    }

    @Test
    @Order(3)
    void update() {
        Notification updated1 = new Notification.Builder().copy(notification2).setMessage("Your reservation has been updated.").build();
        Notification updated = notificationService.update(updated1);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void read() {
        Notification read = notificationService.read(notification1.getNotificationID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(notificationService.getAll());
    }

    @Test
    @Order(6)
    void deleteByRecipient() {
        notificationService.deleteByRecipient(notification1.getRecipient());
        Notification deleted = notificationService.read(notification1.getNotificationID());
        assertNull(deleted);
    }

    @Test
    @Order(7)
    void findByRecipient() {
        Set<Notification> found = notificationService.findByRecipient(notification2.getRecipient());
        assertFalse(found.isEmpty());
        System.out.println(found);
    }
}
