package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.factory.*;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartServiceTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowtimeService showtimeService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private TicketService ticketService;

    private static String userID1, userID2;
    private static String ticketID1, ticketID2;
    private static Cart cart1, cart2;

    @Test
    @Order(1)
    void setUp() {
        // Create user 1
        User user1 = UserFactory.buildUser("Amaan", "Allie", "Amaan.Allie@example.com", "password123", true);
        assertNotNull(user1);
        user1 = userService.create(user1);  // Save user1
        userID1 = String.valueOf(user1.getUserID());  // Assuming there's a getUserID() method
        System.out.println(user1);

        // Create user 2
        User user2 = UserFactory.buildUser("Adam", "Mohamed", "adam.mohamed@example.com", "password456", false);
        assertNotNull(user2);
        user2 = userService.create(user2);  // Save user2
        userID2 = String.valueOf(user2.getUserID());  // Assuming there's a getUserID() method
        System.out.println(user2);

        // Create genre
        Genre g = GenreFactory.buildGenre("Animation", "Movies that are characterized by 2D or 3D graphics.");
        genreService.create(g);

        // Create movie
        Movie b = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", g, "117 mins", "PG-13", "imageURL");
        movieService.create(b);

        // Create showtime
        Showtime showtime = ShowtimeFactory.buildShowtime(LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), b);
        showtimeService.create(showtime);

        // Create cinema
        Cinema cinema = CinemaFactory.buildCinema("Grand Cinema", "Cape Town");
        cinemaService.create(cinema);

        // Create theatre
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        theatreService.create(theatre);

        // Create seats
        Seat seat1 = SeatFactory.buildSeat("D4", "Regular", theatre);
        seatService.create(seat1);
        Seat seat2 = SeatFactory.buildSeat("D5", "Regular", theatre);
        seatService.create(seat2);

        // Create tickets
        Ticket ticket1 = TicketFactory.buildTicket("b", "showtime", "seat1", "theatre", "cinema", "70", "user1");
        ticketID1 = ticketService.create(ticket1).getTicketID();  // Save ticket ID from the created ticket
        Ticket ticket2 = TicketFactory.buildTicket("b", "showtime", "seat2", "theatre", "cinema", "70", "user2");
        ticketID2 = ticketService.create(ticket2).getTicketID();  // Save ticket ID from the created ticket

        // Create carts
        cart1 = CartFactory.buildCart(userID1, ticketID1, "2");
        assertNotNull(cart1);
        System.out.println(cart1);

        cart2 = CartFactory.buildCart(userID2, ticketID2, "3");
        assertNotNull(cart2);
        System.out.println(cart2);
    }

    @Test
    @Order(2)
    void create() {
        Cart created1 = cartService.create(cart1);
        assertNotNull(created1);
        System.out.println(created1);

        Cart created2 = cartService.create(cart2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        String cartID = cart1.getCartID();  // Ensure cart1.getCartID() returns a String
        Cart read = cartService.read(cartID);  // Pass the String cartID to the read method
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Cart updatedCart = new Cart.Builder().copy(cart2).setQuantity("4").build();
        Cart updated = cartService.update(updatedCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        Set<Cart> carts = cartService.getAll();
        assertNotNull(carts);
        System.out.println(carts);
    }
}
