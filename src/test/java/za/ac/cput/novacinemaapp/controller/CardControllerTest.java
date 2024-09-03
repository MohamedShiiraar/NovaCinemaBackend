package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.factory.CardFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardControllerTest {

    private static Card card = CardFactory.buildCard("Mohamed Shiiraar",903489764,"01/25");

    private final String BASE_URL = "http://localhost:8080/card";

    private RestTemplate restTemplate = new RestTemplate();

    private static Long cardID;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> cardEntity = performPostRequest(card);
        String url = BASE_URL + "/create";
        ResponseEntity<Card> postResponse = restTemplate.postForEntity(url,cardEntity,Card.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Card savedCard = postResponse.getBody();
        System.out.println("Saved data : " +savedCard);
        assertNotNull(savedCard);
        cardID = savedCard.getCardID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + cardID;
        System.out.println("URL: " + url);
        ResponseEntity<Card> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(),Card.class);

        Card readCard = getResponse.getBody();
        assertEquals(cardID,readCard.getCardID());
        System.out.println("Read: "+readCard);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Card updatedCard = new Card.Builder().copy(card).setCardHolder("Iyaad Ahsing").build();

        HttpEntity<?> entity = performPostRequest(updatedCard);

        System.out.println("URL: "+url);
        System.out.println("POST data: "+updatedCard);
        ResponseEntity<Card> response = restTemplate.postForEntity(url,updatedCard,Card.class);
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
        String url = BASE_URL + "/delete/" + cardID ;
        System.out.println("URL: " + url);

        HttpEntity<?> Entity = performPostRequest(card);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, Entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
}
