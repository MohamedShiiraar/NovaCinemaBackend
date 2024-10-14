package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.SeatFactory;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {"server.port=8080"})
class SeatControllerTest {
    private static Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema", "6 Ferry street");
    private static Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
    private static Seat seat = SeatFactory.buildSeat("D4","Regular",theatre);

    private final String BASE_URL = "http://localhost:8080/seat";

    private RestTemplate restTemplate = new RestTemplate();

    private static Long seatId;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }
    @Test
    @Order(1)
    void create() {
        HttpEntity<?> promotionEntity = performPostRequest(seat);
        String url = BASE_URL + "/create";
        ResponseEntity<Seat> postResponse = restTemplate.postForEntity(url, promotionEntity, Seat.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Seat savedSeat = postResponse.getBody();
        System.out.println("Saved data: " + savedSeat);
        assertNotNull(savedSeat);
        seatId = savedSeat.getSeatID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + seatId;
        System.out.println("URL: " + url);
        ResponseEntity<Seat> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Seat.class);

        Seat readSeat = getResponse.getBody();
        assertEquals(seatId, readSeat.getSeatID());
        System.out.println("Read: " + readSeat);
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
        Seat updatedSeat = new Seat.Builder().copy(seat).setSeatNumber("B6").build();

        HttpEntity<?> entity = performPostRequest(updatedSeat);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedSeat);
        ResponseEntity<Seat> response = restTemplate.postForEntity(url, updatedSeat, Seat.class);
        assertNotNull(response.getBody());
    }
}