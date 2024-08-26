package za.ac.cput.novacinemaapp.factory;

// Factory for Ticket
// Author Amaan Allie
// 17 May 2024

import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalTime;

public class TicketFactory {

    public static Ticket buildTicket(String ticketID, String movie, LocalTime showtime, String seat, String cinema, double ticketPrice) {
        if (Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(showtime) || Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(ticketPrice))
            return null;

        return new Ticket.Builder()
                .setTicketID(ticketID)
                .setMovie(movie)
                .setShowtime(showtime)
                .setSeat(seat)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .build();
    }

    public static Ticket buildTicket(String movie, LocalTime showtime, String seat, String cinema, double ticketPrice) {
        if (Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(showtime) || Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(ticketPrice))
            return null;

        String ticketID = Helper.generateId();

        return new Ticket.Builder()
                .setTicketID(ticketID)
                .setMovie(movie)
                .setShowtime(showtime)
                .setSeat(seat)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .build();
    }
}
