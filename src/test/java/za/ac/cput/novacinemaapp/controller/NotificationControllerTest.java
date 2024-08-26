package za.ac.cput.novacinemaapp.controller;

/*
NotificationControllerTest.java
Tests for NotificationController
Author: Gammaad Mohamed (220208344)

 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.NotificationFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificationControllerTest {

    private static User user = new User(); // Make sure to set user attributes as needed
    private static Notification notification = NotificationFactory.buildNotification("Your movie starts in 30 minutes", user);
    private final String BASE_URL = "http://localhost:8080/notifications"; // Ensure this matches your controller's URL

    private RestTemplate restTemplate = new RestTemplate();

    private String notificationID;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> notificationEntity = performPostRequest(notification);
        String url = BASE_URL + "/create";
        ResponseEntity<Notification> postResponse = restTemplate.postForEntity(url, notificationEntity, Notification.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());

        Notification savedNotification = postResponse.getBody();
        assertNotNull(savedNotification);
        notificationID = savedNotification.getNotificationID();
        assertNotNull(notificationID);
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + notificationID;
        ResponseEntity<Notification> getResponse = restTemplate.exchange(
                RequestEntity.get(new URI(url)).build(), Notification.class);

        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        Notification readNotification = getResponse.getBody();
        assertNotNull(readNotification);
        assertEquals(notificationID, readNotification.getNotificationID());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Notification updatedNotification = new Notification.Builder()
                .copy(notification)
                .setDescription("Your seat has been upgraded to VIP")
                .build();

        HttpEntity<?> entity = performPostRequest(updatedNotification);

        ResponseEntity<Notification> response = restTemplate.exchange(url, HttpMethod.PUT, entity, Notification.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Notification responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("Your seat has been upgraded to VIP", responseBody.getDescription());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String responseBody = response.getBody();
        assertNotNull(responseBody);
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + notificationID;
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
