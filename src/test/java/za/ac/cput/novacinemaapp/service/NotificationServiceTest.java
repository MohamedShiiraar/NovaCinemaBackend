package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.NotificationFactory;

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
        User user = new User(); // Assuming User is already instantiated correctly
        notification1 = NotificationFactory.buildNotification("Your movie starts in 30 minutes", user);
        assertNotNull(notification1);
        System.out.println(notification1);

        notification2 = NotificationFactory.buildNotification("Your seat has been upgraded", user);
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


}
