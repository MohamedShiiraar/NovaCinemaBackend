package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalTime;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerTest {

    private static Ticket ticket = TicketFactory.buildTicket("1", "Movie", LocalTime.of(18, 0), "A1", "Cinema", 10.00);
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
        Ticket updatedTicket = new Ticket.Builder().copy(ticket).setSeat("B2").build();

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


