package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.factory.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    class ReviewControllerTest {

        private static Genre genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");

        private static Movie movie = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",genre,"117 mins","PG-13","imageURL");
        private static User user = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!",false);

        private static Review review = ReviewFactory.buildReview(4.5, "Great movie!", LocalDate.now(), movie, user);

        private final String BASE_URL = "http://localhost:8080/review";

        private RestTemplate restTemplate = new RestTemplate();

        private static Long reviewId;

        private HttpEntity<?> performPostRequest(Object object) {
            return new HttpEntity<>(object);
        }

        @Test
        @Order(1)
        void create() {
            HttpEntity<?> reviewEntity = performPostRequest(review);
            String url = BASE_URL + "/create";
            ResponseEntity<Review> postResponse = restTemplate.postForEntity(url, reviewEntity, Review.class);
            assertNotNull(postResponse);
            System.out.println(postResponse);
            assertNotNull(postResponse.getBody());

            Review savedReview = postResponse.getBody();
            System.out.println("Saved data: " + savedReview);
            assertNotNull(savedReview);
            reviewId = savedReview.getReviewId();
        }

        @Test
        @Order(2)
        void read() throws URISyntaxException {
            String url = BASE_URL + "/read/" + reviewId;
            System.out.println("URL: " + url);
            ResponseEntity<Review> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Review.class);

            Review readReview = getResponse.getBody();
            assertEquals(reviewId, readReview.getReviewId());
            System.out.println("Read: " + readReview);
        }

        @Test
        @Order(3)
        void update() {
            String url = BASE_URL + "/update";
            Review updatedReview = new Review.Builder().copy(review).setComment("Amazing movie!").build();

            HttpEntity<?> entity = performPostRequest(updatedReview);

            System.out.println("URL: " + url);
            System.out.println("POST data: " + updatedReview);
            ResponseEntity<Review> response = restTemplate.postForEntity(url, updatedReview, Review.class);
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

