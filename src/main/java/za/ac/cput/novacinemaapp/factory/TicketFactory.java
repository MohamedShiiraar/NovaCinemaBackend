package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalTime;

public class TicketFactory {

    public static Ticket buildTicket(Movie movie, Showtime showtime, Seat seat,Theatre theatre, Cinema cinema, double ticketPrice) {
        if (Helper.isNullOrEmpty(movie) || showtime == null || Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) || ticketPrice <= 0 || Helper.isNullOrEmpty(theatre))
            return null;

        return new Ticket.Builder()
                .setMovie(movie)
                .setShowtime(showtime)
                .setSeat(seat)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .build();
    }
}
