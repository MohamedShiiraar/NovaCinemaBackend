package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.util.Helper;

public class TicketFactory {

    public static Ticket buildTicket(Movie movie, String showtime, String seat, String theatre, Cinema cinema, double ticketPrice, User userID) {
        if (Helper.isNullOrEmpty(movie) || showtime == null || Helper.isNullOrEmpty(seat) ||
                Helper.isNullOrEmpty(cinema) || ticketPrice <= 0 || Helper.isNullOrEmpty(theatre) ||
                userID == null) {
            return null;
        }

        return new Ticket.Builder()
                .setMovie(movie)
                .setShowtime(showtime)
                .setSeat(seat)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .setUserID(userID)
                .build();
    }
}

