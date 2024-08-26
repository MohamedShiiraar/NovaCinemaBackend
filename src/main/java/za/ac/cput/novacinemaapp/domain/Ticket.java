package za.ac.cput.novacinemaapp.domain;

// Entity for Ticket
// Author Amaan Allie
// 17 May 2024

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Ticket {
    @Id
    private String ticketID;
    private String movie;
    private LocalTime showtime;
    private String seat;
    private String cinema;
    private double ticketPrice;

    public Ticket() {
    }

    public Ticket(Builder builder) {
        this.ticketID = builder.ticketID;
        this.movie = builder.movie;
        this.showtime = builder.showtime;
        this.seat = builder.seat;
        this.cinema = builder.cinema;
        this.ticketPrice = builder.ticketPrice;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getMovie() {
        return movie;
    }

    public LocalTime getShowtime() {
        return showtime;
    }

    public String getSeat() {
        return seat;
    }

    public String getCinema() {
        return cinema;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Double.compare(ticket.ticketPrice, ticketPrice) == 0 &&
                Objects.equals(ticketID, ticket.ticketID) &&
                Objects.equals(movie, ticket.movie) &&
                Objects.equals(showtime, ticket.showtime) &&
                Objects.equals(seat, ticket.seat) &&
                Objects.equals(cinema, ticket.cinema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, movie, showtime, seat, cinema, ticketPrice);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", movie='" + movie + '\'' +
                ", showtime=" + showtime +
                ", seat='" + seat + '\'' +
                ", cinema='" + cinema + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public static class Builder {
        private String ticketID;
        private String movie;
        private LocalTime showtime;
        private String seat;
        private String cinema;
        private double ticketPrice;

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setMovie(String movie) {
            this.movie = movie;
            return this;
        }

        public Builder setShowtime(LocalTime showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setSeat(String seat) {
            this.seat = seat;
            return this;
        }

        public Builder setCinema(String cinema) {
            this.cinema = cinema;
            return this;
        }

        public Builder setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public Builder copy(Ticket ticket) {
            this.ticketID = ticket.ticketID;
            this.movie = ticket.movie;
            this.showtime = ticket.showtime;
            this.seat = ticket.seat;
            this.cinema = ticket.cinema;
            this.ticketPrice = ticket.ticketPrice;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}

