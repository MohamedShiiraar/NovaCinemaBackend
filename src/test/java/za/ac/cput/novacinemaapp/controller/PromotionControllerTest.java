package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Promotion;
import za.ac.cput.novacinemaapp.factory.PromotionFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PromotionControllerTest {

    private static Promotion promotion = PromotionFactory.buildPromotion("Student Discount","Get 20% off on all movie tickets with your student ID",0.20f, LocalDateTime.parse("2024-08-29T00:00:00"),LocalDateTime.now());

    private final String BASE_URL = "http://localhost:8080/promotion";

    private RestTemplate restTemplate = new RestTemplate();

    private static Long promotionId;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }
    @Test
    @Order(1)
    void create() {
        HttpEntity<?> promotionEntity = performPostRequest(promotion);
        String url = BASE_URL + "/create";
        ResponseEntity<Promotion> postResponse = restTemplate.postForEntity(url, promotionEntity, Promotion.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Promotion savedPromotion = postResponse.getBody();
        System.out.println("Saved data: " + savedPromotion);
        assertNotNull(savedPromotion);
        promotionId = savedPromotion.getPromotionID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + promotionId;
        System.out.println("URL: " + url);
        ResponseEntity<Promotion> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Promotion.class);

        Promotion readPromotion = getResponse.getBody();
        assertEquals(promotionId, readPromotion.getPromotionID());
        System.out.println("Read: " + readPromotion);
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
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Promotion updatedPromotion = new Promotion.Builder().copy(promotion).setPromotionName("Family Promotion").build();

        HttpEntity<?> entity = performPostRequest(updatedPromotion);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedPromotion);
        ResponseEntity<Promotion> response = restTemplate.postForEntity(url, updatedPromotion, Promotion.class);
        assertNotNull(response.getBody());
    }
}