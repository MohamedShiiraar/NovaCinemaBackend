package za.ac.cput.novacinemaapp.factory;

// Entity for Ticket
// Author Amaan Allie
// 17 May 2024

import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketFactory {
    public static Ticket buildTicket(String ticketID, String movie, String theatre, String cinema, double ticketPrice, LocalDate date, LocalTime time) {
        if (Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(theatre) || Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(ticketPrice) || Helper.isNullOrEmpty(date) || Helper.isNullOrEmpty(time))
            return null;

        return new Ticket.Builder().setTicketID(ticketID).setMovie(movie)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .setDate(date)
                .setTime(time)
                .build();
    }

    public static Ticket buildTicket(String movie, String theatre, String cinema, double ticketPrice, LocalDate date, LocalTime time) {
        if (Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(theatre) || Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(ticketPrice) || Helper.isNullOrEmpty(date) || Helper.isNullOrEmpty(time))
            return null;

        String ticketID = Helper.generateId();

        return new Ticket.Builder().setTicketID(ticketID).setMovie(movie)
                .setTheatre(theatre)
                .setCinema(cinema)
                .setTicketPrice(ticketPrice)
                .setDate(date)
                .setTime(time)
                .build();
    }
}
