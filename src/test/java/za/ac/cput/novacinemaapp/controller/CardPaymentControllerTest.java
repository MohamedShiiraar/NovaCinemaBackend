package za.ac.cput.novacinemaapp.controller;
/*
 * Jared Barros 219116962
 * 18/05/2024
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.factory.CardPaymentFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardPaymentControllerTest {

    private static CardPayment cardPayment = CardPaymentFactory.buildCardPayment("1", "Mo Shire", 9034897641234567L, "01/25", 250.00);

    private final String BASE_URL = "http://localhost:8080/cardpayment";

    private RestTemplate restTemplate = new RestTemplate();

    private static String cardHolder;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> cardPaymentEntity = performPostRequest(cardPayment);
        String url = BASE_URL + "/create";
        ResponseEntity<CardPayment> postResponse = restTemplate.postForEntity(url, cardPaymentEntity, CardPayment.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        CardPayment savedCardPayment = postResponse.getBody();
        System.out.println("Saved data : " + savedCardPayment);
        assertNotNull(savedCardPayment);
        cardHolder = savedCardPayment.getCardHolder();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + cardHolder;
        System.out.println("URL: " + url);
        ResponseEntity<CardPayment> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), CardPayment.class);

        CardPayment readCardPayment = getResponse.getBody();
        assertEquals(cardHolder, readCardPayment.getCardHolder());
        System.out.println("Read: " + readCardPayment);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        CardPayment updatedCardPayment = new CardPayment.Builder().copy(cardPayment).setCardHolder("Iyaad Ahsing").build();

        HttpEntity<?> entity = performPostRequest(updatedCardPayment);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedCardPayment);
        ResponseEntity<CardPayment> response = restTemplate.postForEntity(url, updatedCardPayment, CardPayment.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + cardHolder;
        System.out.println("URL: " + url);

        HttpEntity<?> entity = performPostRequest(cardPayment);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
