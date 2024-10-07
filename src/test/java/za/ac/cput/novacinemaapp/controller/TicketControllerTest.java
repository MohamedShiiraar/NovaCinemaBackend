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

import java.time.LocalDateTime;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerTest {

    private static Genre genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");
    private static Movie movie = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", genre, "117 mins", "PG-13", "imageURL");
    private static Showtime showtime = ShowtimeFactory.buildShowtime(LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), movie);
    private static Cinema cinema = CinemaFactory.buildCinema("Grand Cinema", "Cape Town");
    private static Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
    private static Seat seat = SeatFactory.buildSeat("D4", "Regular", theatre);

    // Create a User object to use in the test
    private static User user = UserFactory.buildUser("JohnDoe", "password", "johndoe@example.com", "John", Boolean.parseBoolean("Doe"));

    // Update the Ticket object to include the userID
    private static Ticket ticket = TicketFactory.buildTicket( "movie", "showtime", "seat", "theatre", "cinema", "70", "user");
    private final String BASE_URL = "http://localhost:8080/ticket";
    private RestTemplate restTemplate = new RestTemplate();
    private static String ticketID;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> ticketEntity = performPostRequest(ticket);
        String url = BASE_URL + "/create";
        ResponseEntity<Ticket> postResponse = restTemplate.postForEntity(url, ticketEntity, Ticket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Ticket savedTicket = postResponse.getBody();
        System.out.println("Saved data : " + savedTicket);
        assertNotNull(savedTicket);
        ticketID = savedTicket.getTicketID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + ticketID;
        ResponseEntity<Ticket> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Ticket.class);

        Ticket readTicket = getResponse.getBody();
        assertNotNull(readTicket);
        assertEquals(ticketID, readTicket.getTicketID());
        System.out.println("Read: " + readTicket);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Ticket updatedTicket = new Ticket.Builder().copy(ticket).setTicketPrice("70").build();

        HttpEntity<?> entity = performPostRequest(updatedTicket);

        ResponseEntity<Ticket> response = restTemplate.postForEntity(url, entity, Ticket.class);
        assertNotNull(response.getBody());
        System.out.println("Updated data: " + response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println("All tickets: " + response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + ticketID;
        HttpEntity<?> entity = performPostRequest(ticket);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}

