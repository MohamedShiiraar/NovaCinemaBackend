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
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTest {


    private static User user = UserFactory.buildUser( "Amaan", "Allie", "Amaan.Allie@example.com", "password123",false);
    private static Genre genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");
    private static Movie movie = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",genre,"117 mins","PG-13","imageURL");
    private static Showtime showtime = ShowtimeFactory.buildShowtime( LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), movie);
    private static Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema", "6 Ferry street");
    private static Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
    private static Seat seat = SeatFactory.buildSeat("D4","Regular",theatre);
    private static Ticket ticket = TicketFactory.buildTicket(movie, showtime, seat, theatre,cinema, 69.00, user);
    private static Cart cart = CartFactory.buildCart(user, ticket, "2");



    private final String BASE_URL = "http://localhost:8080/cart";
    private RestTemplate restTemplate = new RestTemplate();
    private static String cartID;

    private HttpEntity<?> performPostRequest(Object object) {
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void setUp() {
        // Create and persist the user
        user = UserFactory.buildUser("Amaan", "Allie", "Amaan.Allie@example.com", "password123", false);
        // Assume there's a UserService to handle user persistence
        // userService.create(user);

        // Create and persist other entities
        genre = GenreFactory.buildGenre("Action", "Fast-paced, high-energy films with physical stunts and chases.");
        movie = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", genre, "117 mins", "PG-13", "imageURL");
        showtime = ShowtimeFactory.buildShowtime(LocalDateTime.of(2024, 8, 29, 0, 0), LocalDateTime.of(2024, 8, 29, 0, 0), movie);
        cinema = CinemaFactory.buildCinema("Grand Cinema", "6 Ferry street");
        theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        seat = SeatFactory.buildSeat("D4", "Regular", theatre);
        ticket = TicketFactory.buildTicket(movie, showtime, seat, theatre, cinema, 69.00, user);

        // Create a cart with the user
        cart = CartFactory.buildCart(user, ticket, "2");
    }

    @Test
    @Order(2)
    void create() {
        HttpEntity<?> cartEntity = performPostRequest(cart);
        String url = BASE_URL + "/create";
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cartEntity, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Cart savedCart = postResponse.getBody();
        System.out.println("Saved data : " + savedCart);
        assertNotNull(savedCart);
        cartID = String.valueOf(savedCart.getCartID());
    }

    @Test
    @Order(3)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + cartID;
        ResponseEntity<Cart> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(), Cart.class);

        Cart readCart = getResponse.getBody();
        assertNotNull(readCart);
        assertEquals(cartID, readCart.getCartID());
        System.out.println("Read: " + readCart);
    }

    @Test
    @Order(4)
    void update() {
        String url = BASE_URL + "/update";
        Cart updatedCart = new Cart.Builder().copy(cart).setQuantity("3").build();

        HttpEntity<?> entity = performPostRequest(updatedCart);

        ResponseEntity<Cart> response = restTemplate.postForEntity(url, entity, Cart.class);
        assertNotNull(response.getBody());
        System.out.println("Updated data: " + response.getBody());
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println("All carts: " + response.getBody());
    }

    @Test
    @Order(6)
    void delete() {
        String url = BASE_URL + "/delete/" + cartID;
        HttpEntity<?> entity = performPostRequest(cart);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}

