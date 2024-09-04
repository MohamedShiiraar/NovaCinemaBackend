package za.ac.cput.novacinemaapp.controller;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;
import za.ac.cput.novacinemaapp.factory.GenreFactory;
import za.ac.cput.novacinemaapp.factory.MovieFactory;
import za.ac.cput.novacinemaapp.factory.ShowtimeFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    class ShowtimeControllerTest {

        private static Genre genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");
        private static Movie movie = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",genre,"117 mins","PG-13","imageURL");
        private static Showtime showtime = ShowtimeFactory.buildShowtime(LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), movie);

        private final String BASE_URL = "http://localhost:8080/showtime";

        private RestTemplate restTemplate = new RestTemplate();

        private static Long showtimeId;

        private HttpEntity<?> performPostRequest(Object object) {
            return new HttpEntity<>(object);
        }

        @Test
        @Order(1)
        void create() {
            HttpEntity<?> showtimeEntity = performPostRequest(showtime);
            String url = BASE_URL + "/create";
            ResponseEntity<Showtime> postResponse = restTemplate.postForEntity(url, showtimeEntity, Showtime.class);
            assertNotNull(postResponse);
            System.out.println(postResponse);
            assertNotNull(postResponse.getBody());

            Showtime savedShowtime = postResponse.getBody();
            System.out.println("Saved data: " + savedShowtime);
            assertNotNull(savedShowtime);
            showtimeId = savedShowtime.getShowtimeId();
        }

        @Test
        @Order(2)
        void read() throws URISyntaxException {
            String url = BASE_URL + "/read/" + showtimeId;
            System.out.println("URL: " + url);
            ResponseEntity<Showtime> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Showtime.class);

            Showtime readShowtime = getResponse.getBody();
            assertEquals(showtimeId, readShowtime.getShowtimeId());
            System.out.println("Read: " + readShowtime);
        }

        @Test
        @Order(3)
        void update() {
            String url = BASE_URL + "/update";
            Showtime updatedShowtime = new Showtime.Builder().copy(showtime).setShowtime(LocalDateTime.parse("2024-09-04T19:00:00")).build();

            HttpEntity<?> entity = performPostRequest(updatedShowtime);

            System.out.println("URL: " + url);
            System.out.println("POST data: " + updatedShowtime);
            ResponseEntity<Showtime> response = restTemplate.postForEntity(url, updatedShowtime, Showtime.class);
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


    }
