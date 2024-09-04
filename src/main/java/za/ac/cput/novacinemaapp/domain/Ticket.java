package za.ac.cput.novacinemaapp.domain;

// Entity for Ticket
// Author Amaan Allie
// 17 May 2024

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketID;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Showtime showtime;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Cinema cinema;
    private double ticketPrice;
    @ManyToOne
    private User userID;

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
        return Double.compare(ticket.ticketPrice, ticketPrice) == 0 &&
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
                "ticketID=" + ticketID +
                ", movie=" + movie +
                ", showtime=" + showtime +
                ", seat=" + seat +
                ", theatre=" + theatre +
                ", cinema=" + cinema +
                ", ticketPrice=" + ticketPrice +
                ", userID=" + userID +
                '}';
    }

    public static class Builder {
        private Long ticketID;
        private Movie movie;
        private Showtime showtime;
        private Seat seat;
        private Theatre theatre;
        private Cinema cinema;
        private double ticketPrice;
        private User userID;

        public Builder setTicketID(Long ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public Builder setShowtime(Showtime showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Builder setTheatre(Theatre theatre) {
            this.theatre = theatre;
            return this;
        }

        public Builder setCinema(Cinema cinema) {
            this.cinema = cinema;
            return this;
        }

        public Builder setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public Builder setUserID(User userID) {
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

