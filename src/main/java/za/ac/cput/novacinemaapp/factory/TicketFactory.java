package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalTime;

public class TicketFactory {

    public static Ticket buildTicket(long ticketID, String movie, LocalTime showtime, String seat, String cinema, double ticketPrice) {
        if (ticketID <= 0 || Helper.isNullOrEmpty(movie) || showtime == null || Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) || ticketPrice <= 0)
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
        if (Helper.isNullOrEmpty(movie) || showtime == null || Helper.isNullOrEmpty(seat) || Helper.isNullOrEmpty(cinema) || ticketPrice <= 0)
            return null;

        long ticketID = Long.parseLong(Helper.generateId());

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
