package za.ac.cput.novacinemaapp.factory;

// Test for TicketFactory
// Author Amaan Allie
// 17 May 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void testBuildTicket() {
        Genre g = GenreFactory.buildGenre("Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", g, "117 mins", "PG-13", "imageURL");
        assertNotNull(b);

        Showtime showtime = ShowtimeFactory.buildShowtime( LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), b);

        Showtime showtime = ShowtimeFactory.buildShowtime(LocalTime.of(10, 0), LocalTime.of(12, 0), b);

        assertNotNull(showtime);
        Cinema cinema = CinemaFactory.buildCinema("Grand Cinema");
        assertNotNull(cinema);
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        Seat seat = SeatFactory.buildSeat("D4", "Regular", theatre);
        assertNotNull(seat);

        // Create a User object to use in the test
        User user = UserFactory.buildUser("JohnDoe", "password", "johndoe@example.com", "John", Boolean.parseBoolean("Doe"));
        assertNotNull(user);

        // Updated Ticket creation with userID
        Ticket ticket = TicketFactory.buildTicket(b, showtime, seat, theatre, cinema, 69.0, user);
        assertNotNull(ticket);
        System.out.println(ticket.toString());
    }

    @Test
    void testBuildTicketWithFail() {
        Genre g = GenreFactory.buildGenre("Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", g, "117 mins", "PG-13", "imageURL");
        assertNotNull(b);

        Showtime showtime = ShowtimeFactory.buildShowtime( LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), b);

        Showtime showtime = ShowtimeFactory.buildShowtime(LocalTime.of(10, 0), LocalTime.of(12, 0), b);

        assertNotNull(showtime);
        Cinema cinema = CinemaFactory.buildCinema("Grand Cinema");
        assertNotNull(cinema);
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        Seat seat = SeatFactory.buildSeat("D4", "Regular", theatre);
        assertNotNull(seat);

        // Create a User object to use in the test
        User user = UserFactory.buildUser("JohnDoe", "password", "johndoe@example.com", "John", Boolean.parseBoolean("Doe"));
        assertNotNull(user);

        // Ticket creation with an invalid price
        Ticket ticket = TicketFactory.buildTicket(b, showtime, seat, theatre, cinema, 0.0, user);
        assertNull(ticket); // Changed to assertNull as the factory should return null for invalid input
    }
}
