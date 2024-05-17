package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketFactory {
    public static Ticket buildTicket(String ticketID, String movie, String theatre, String cinema, double ticketPrice, LocalDate date, LocalTime time) {
        if (Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(theatre) || Helper.isNullOrEmpty(cinema) || ticketPrice <= 0 || date == null || time == null)
            return null;

        return new Ticket.Builder().setTicketID(ticketID)
                .setMovie(movie)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .setDate(date)
                .setTime(time)
                .build();
    }

    public static Ticket buildTicket(String movie, String theatre, String cinema, double ticketPrice, LocalDate date, LocalTime time) {
        if (Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(theatre) || Helper.isNullOrEmpty(cinema) || ticketPrice <= 0 || date == null || time == null)
            return null;

        String ticketID = Helper.generateId();

        return new Ticket.Builder().setTicketID(ticketID)
                .setMovie(movie)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .setDate(date)
                .setTime(time)
                .build();
    }
}
