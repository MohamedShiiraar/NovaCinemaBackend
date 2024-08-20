package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.MovieFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTest {

    private static Movie movie = MovieFactory.buildMovie("2","Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.","animation","117 mins","PG-13");
    private final String BASE_URL = "http://localhost:8080/movie";

    private RestTemplate restTemplate = new RestTemplate();

    private static String movieID;

    private HttpEntity<?>performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> movieEntity = performPostRequest(movie);
        String url = BASE_URL + "/create";
        ResponseEntity<Movie> postResponse = restTemplate.postForEntity(url,movieEntity,Movie.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Movie savedMovie = postResponse.getBody();
        System.out.println("Saved data : " +savedMovie);
        assertNotNull(savedMovie);
        movieID = savedMovie.getMovieID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + movieID;
        System.out.println("URL: " + url);
        ResponseEntity<Movie> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(),Movie.class);

        Movie readMovie = getResponse.getBody();
        assertEquals(movieID,readMovie.getMovieID());
        System.out.println("Read: "+readMovie);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Movie updatedMovie = new Movie.Builder().copy(movie).setDuration("120 mins").build();

        HttpEntity<?> entity = performPostRequest(updatedMovie);

        System.out.println("URL: "+url);
        System.out.println("POST data: "+updatedMovie);
        ResponseEntity<Movie> response = restTemplate.postForEntity(url,updatedMovie,Movie.class);
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
        String url = BASE_URL + "/delete/" + movieID ;
        System.out.println("URL: " + url);

        HttpEntity<?> Entity = performPostRequest(movie);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, Entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }




}
