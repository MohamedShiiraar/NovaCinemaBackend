package za.ac.cput.novacinemaapp.factory;

// Test for CartFactory
// Author Amaan Allie
// 27 August 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.factory.CartFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void testBuildCart() {
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Showtime showtime = ShowtimeFactory.buildShowtime( LocalTime.of(10, 0), LocalTime.of(12, 0), b);
        assertNotNull(showtime);
        Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema");
        assertNotNull(cinema);
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        Seat seat = SeatFactory.buildSeat("D4","Regular",theatre);
        assertNotNull(seat);
        User user = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!",true);
        assertNotNull(b);
        Ticket ticket = TicketFactory.buildTicket(b,showtime, seat, theatre, cinema,69.0, user);
        assertNotNull(ticket);
        Cart cart = CartFactory.buildCart(user, ticket, "2");
        assertNotNull(cart);
        System.out.println(cart.toString());
    }

    @Test
    void testBuildCartWithFail() {
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Showtime showtime = ShowtimeFactory.buildShowtime( LocalTime.of(10, 0), LocalTime.of(12, 0), b);
        assertNotNull(showtime);
        Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema");
        assertNotNull(cinema);
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        Seat seat = SeatFactory.buildSeat("D4","Regular",theatre);
        assertNotNull(seat);
        User user = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!",false);
        assertNotNull(b);
        Ticket ticket = TicketFactory.buildTicket(b,showtime, seat, theatre, cinema,69.0, user);
        assertNotNull(ticket);
        Cart cart = CartFactory.buildCart(user, ticket, null);
        assertNotNull(cart);
    }
}
