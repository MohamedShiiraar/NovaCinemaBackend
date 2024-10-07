package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

public class TicketFactory {

    public static Ticket buildTicket(String movie, String showtime, String seat, String theatre, String cinema, String ticketPrice, String userID) {
        // Validation checks for null or empty fields
        if (Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(showtime) ||
                Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) ||
                Helper.isNullOrEmpty(ticketPrice) || Helper.isNullOrEmpty(theatre) ||
                Helper.isNullOrEmpty(userID)) {
            return null;
        }

        // Return a new Ticket object using the builder pattern
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

