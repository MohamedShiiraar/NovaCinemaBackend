package za.ac.cput.novacinemaapp.controller;

/*
GammaadMohamed-220208344
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.factory.GenreFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenreControllerTest {

    private static Genre genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");
    private final String BASE_URL = "http://localhost:8080/genre";

    private RestTemplate restTemplate = new RestTemplate();

    private static Long genreID;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> genreEntity = performPostRequest(genre);
        String url = BASE_URL + "/create";
        ResponseEntity<Genre> postResponse = restTemplate.postForEntity(url, genreEntity, Genre.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Genre savedGenre = postResponse.getBody();
        System.out.println("Saved data : " + savedGenre);
        assertNotNull(savedGenre);
        genreID = savedGenre.getGenreID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + genreID;
        System.out.println("URL: " + url);
        ResponseEntity<Genre> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Genre.class);

        Genre readGenre = getResponse.getBody();
        assertEquals(genreID, readGenre.getGenreID());
        System.out.println("Read: " + readGenre);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Genre updatedGenre = new Genre.Builder().copy(genre).setDescription("High-energy films featuring physical stunts, chases, and explosions.").build();

        HttpEntity<?> entity = performPostRequest(updatedGenre);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedGenre);
        ResponseEntity<Genre> response = restTemplate.postForEntity(url, entity, Genre.class);
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
        String url = BASE_URL + "/delete/" + genreID;
        System.out.println("URL: " + url);

        HttpEntity<?> entity = performPostRequest(genre);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
