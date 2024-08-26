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
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CinemaControllerTest {

    private static Cinema cinema = CinemaFactory.buildCinema("L123", "Grand Cinema");

    private final String BASE_URL = "http://localhost:8080/cinema";

    private RestTemplate restTemplate = new RestTemplate();

    private static String cinemaId;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> cinemaEntity = performPostRequest(cinema);
        String url = BASE_URL + "/create";
        ResponseEntity<Cinema> postResponse = restTemplate.postForEntity(url, cinemaEntity, Cinema.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Cinema savedCinema = postResponse.getBody();
        System.out.println("Saved data: " + savedCinema);
        assertNotNull(savedCinema);
        cinemaId = savedCinema.getLocationID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + cinemaId;
        System.out.println("URL: " + url);
        ResponseEntity<Cinema> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Cinema.class);

        Cinema readCinema = getResponse.getBody();
        assertEquals(cinemaId, readCinema.getLocationID());
        System.out.println("Read: " + readCinema);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Cinema updatedCinema = new Cinema.Builder().copy(cinema).setName("Grand Luxury Cinema").build();

        HttpEntity<?> entity = performPostRequest(updatedCinema);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedCinema);
        ResponseEntity<Cinema> response = restTemplate.postForEntity(url, updatedCinema, Cinema.class);
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
        String url = BASE_URL + "/delete/" + cinemaId;
        System.out.println("URL: " + url);

        HttpEntity<?> entity = performPostRequest(cinema);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
