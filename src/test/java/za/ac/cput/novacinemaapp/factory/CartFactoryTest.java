package za.ac.cput.novacinemaapp.factory;

// Test for CartFactory
// Author Amaan Allie
// 27 August 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.factory.CartFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void testBuildCart() {
        // Create a genre
        Genre g = GenreFactory.buildGenre("Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);

        // Create a movie
        Movie b = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", g, "117 mins", "PG-13", "imageURL");
        assertNotNull(b);

        // Create a showtime
        Showtime showtime = ShowtimeFactory.buildShowtime(LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), b);
        assertNotNull(showtime);

        // Create a cinema
        Cinema cinema = CinemaFactory.buildCinema("Grand Cinema", "Cape Town");
        assertNotNull(cinema);

        // Create a theatre
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);

        // Create a seat
        Seat seat = SeatFactory.buildSeat("D4", "Regular", theatre);
        assertNotNull(seat);

        // Create a user and get user ID as String
        String userID = "mso2shiiraar@gmail.com"; // Use user email or ID
        User user = UserFactory.buildUser("Mohamed", "Shiiraar", userID, "Test123!", true);
        assertNotNull(user);

        // Create a ticket and get ticket ID as String
        String ticketID = "ticket-123"; // Example ticket ID
        Ticket ticket = TicketFactory.buildTicket("b", "showtime", "seat", "theatre", "cinema", "70", "user");
        assertNotNull(ticket);

        // Create a cart using userID and ticketID
        Cart cart = CartFactory.buildCart(userID, ticketID, "2");
        assertNotNull(cart);
        System.out.println(cart.toString());
    }

    @Test
    void testBuildCartWithFail() {
        // Create a genre
        Genre g = GenreFactory.buildGenre("Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);

        // Create a movie
        Movie b = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", g, "117 mins", "PG-13", "imageURL");
        assertNotNull(b);

        // Create a showtime
        Showtime showtime = ShowtimeFactory.buildShowtime(LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), b);
        assertNotNull(showtime);

        // Create a cinema
        Cinema cinema = CinemaFactory.buildCinema("Grand Cinema", "Cape Town");
        assertNotNull(cinema);

        // Create a theatre
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);

        // Create a seat
        Seat seat = SeatFactory.buildSeat("D4", "Regular", theatre);
        assertNotNull(seat);

        // Create a user and get user ID as String
        String userID = "mso2shiiraar@gmail.com"; // Use user email or ID
        User user = UserFactory.buildUser("Mohamed", "Shiiraar", userID, "Test123!", false);
        assertNotNull(user);

        // Create a ticket and get ticket ID as String
        String ticketID = "ticket-123"; // Example ticket ID
        Ticket ticket = TicketFactory.buildTicket("b", "showtime", "seat", "theatre", "cinema", "70", "user");
        assertNotNull(ticket);

        // Create a cart with null quantity
        Cart cart = CartFactory.buildCart(userID, ticketID, null);
        assertNotNull(cart); // This may still return a cart object; verify expected behavior
    }
}
