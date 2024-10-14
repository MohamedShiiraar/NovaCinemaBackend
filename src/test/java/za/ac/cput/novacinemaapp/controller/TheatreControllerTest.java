package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheatreControllerTest {
    private static Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema", "6 Ferry street");

    private static Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);

    private final String BASE_URL = "http://localhost:8080/theatre";

    private RestTemplate restTemplate = new RestTemplate();

    private static Long theatreId;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }
    @Test
    @Order(1)
    void create() {
        HttpEntity<?> promotionEntity = performPostRequest(theatre);
        String url = BASE_URL + "/create";
        ResponseEntity<Theatre> postResponse = restTemplate.postForEntity(url, promotionEntity, Theatre.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Theatre savedTheatre = postResponse.getBody();
        System.out.println("Saved data: " + savedTheatre);
        assertNotNull(savedTheatre);
        theatreId = savedTheatre.getTheatreID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + theatreId;
        System.out.println("URL: " + url);
        ResponseEntity<Theatre> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Theatre.class);

        Theatre readTheatre = getResponse.getBody();
        assertEquals(theatreId, readTheatre.getTheatreID());
        System.out.println("Read: " + readTheatre);
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
        Theatre updatedTheatre = new Theatre.Builder().copy(theatre).setTheatreType("2D").build();

        HttpEntity<?> entity = performPostRequest(updatedTheatre);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedTheatre);
        ResponseEntity<Theatre> response = restTemplate.postForEntity(url, updatedTheatre, Theatre.class);
        assertNotNull(response.getBody());
    }
}