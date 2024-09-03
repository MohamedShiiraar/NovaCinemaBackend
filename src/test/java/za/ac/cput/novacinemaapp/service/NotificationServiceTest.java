package za.ac.cput.novacinemaapp.service;

/*
GammaadMohamed-220208344
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.NotificationFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    private static Notification notification1, notification2;
    private static User user;

    @Test
    @Order(1)
    void setUp() {
        user = UserFactory.buildUser( "Mohamed", "Shiiraar", "mso2shiiraar@gmail.com", "Test123!",false);
        userService.create(user);
        assertNotNull(user);

        notification1 = NotificationFactory.buildNotification("1","Your movie starts in 30 minutes", user);
        notification2 = NotificationFactory.buildNotification("2","Your seat has been upgraded", user);
        assertNotNull(notification1);
        assertNotNull(notification2);

        System.out.println(notification1);
        System.out.println(notification2);
    }

    @Test
    @Order(2)
    void create() {
        Notification created1 = notificationService.create(notification1);
        Notification created2 = notificationService.create(notification2);
        assertNotNull(created1);
        assertNotNull(created2);

        System.out.println(created1);
        System.out.println(created2);
    }
    @Test
    @Order(4)
    void read() {
        Notification readNotification = notificationService.read(notification1.getNotificationID());
        assertNotNull(readNotification);
        System.out.println(readNotification);
    }

    @Test
    @Order(3)
    void update() {
        Notification updatedNotification = new Notification.Builder()
                .copy(notification1)
                .setDescription("Updated description")
                .build();
        Notification updated = notificationService.update(updatedNotification);
        System.out.println(updated);

    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(notificationService.getAll());
    }
}
