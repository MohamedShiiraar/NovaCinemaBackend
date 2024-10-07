package za.ac.cput.novacinemaapp.domain;

// Entity for Ticket
// Author Amaan Allie
// 17 May 2024

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ticketID;
    private String movie;
    private String showtime;
    private String seat;
    private String theatre;
    private String cinema;
    private String ticketPrice;
    private String userID;

    public Ticket() {
    }

    public Ticket(Builder builder) {
        this.ticketID = builder.ticketID;
        this.movie = builder.movie;
        this.showtime = builder.showtime;
        this.seat = builder.seat;
        this.theatre = builder.theatre;
        this.cinema = builder.cinema;
        this.ticketPrice = builder.ticketPrice;
        this.userID = builder.userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketPrice, ticket.ticketPrice) &&
                Objects.equals(ticketID, ticket.ticketID) &&
                Objects.equals(movie, ticket.movie) &&
                Objects.equals(showtime, ticket.showtime) &&
                Objects.equals(seat, ticket.seat) &&
                Objects.equals(theatre, ticket.theatre) &&
                Objects.equals(cinema, ticket.cinema) &&
                Objects.equals(userID, ticket.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, movie, showtime, seat, theatre, cinema, ticketPrice, userID);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", movie='" + movie + '\'' +
                ", showtime='" + showtime + '\'' +
                ", seat='" + seat + '\'' +
                ", theatre='" + theatre + '\'' +
                ", cinema='" + cinema + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public static class Builder {
        private String ticketID;
        private String movie;
        private String showtime;
        private String seat;
        private String theatre;
        private String cinema;
        private String ticketPrice;
        private String userID;

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setMovie(String movie) {
            this.movie = movie;
            return this;
        }

        public Builder setShowtime(String showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setSeat(String seat) {
            this.seat = seat;
            return this;
        }

        public Builder setTheatre(String theatre) {
            this.theatre = theatre;
            return this;
        }

        public Builder setCinema(String cinema) {
            this.cinema = cinema;
            return this;
        }

        public Builder setTicketPrice(String ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder copy(Ticket ticket) {
            this.ticketID = ticket.ticketID;
            this.movie = ticket.movie;
            this.showtime = ticket.showtime;
            this.seat = ticket.seat;
            this.theatre = ticket.theatre;
            this.cinema = ticket.cinema;
            this.ticketPrice = ticket.ticketPrice;
            this.userID = ticket.userID;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
