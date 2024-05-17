package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Ticket {
    @Id
    private String ticketID;
    private String movie;
    private String theatre;
    private String cinema;
    private double ticketPrice;
    private LocalDate date;
    private LocalTime time;

    public Ticket() {
    }

    public Ticket(Builder builder) {
        this.ticketID = builder.ticketID;
        this.movie = builder.movie;
        this.theatre = builder.theatre;
        this.cinema = builder.cinema;
        this.ticketPrice = builder.ticketPrice;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getMovie() {
        return movie;
    }

    public String getTheatre() {
        return theatre;
    }

    public String getCinema() {
        return cinema;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Double.compare(ticket.ticketPrice, ticketPrice) == 0 && Objects.equals(ticketID, ticket.ticketID) && Objects.equals(movie, ticket.movie) && Objects.equals(theatre, ticket.theatre) && Objects.equals(cinema, ticket.cinema) && Objects.equals(date, ticket.date) && Objects.equals(time, ticket.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, movie, theatre, cinema, ticketPrice, date, time);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", movie='" + movie + '\'' +
                ", theatre='" + theatre + '\'' +
                ", cinema='" + cinema + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private String ticketID;
        private String movie;
        private String theatre;
        private String cinema;
        private double ticketPrice;
        private LocalDate date;
        private LocalTime time;

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setMovie(String movie) {
            this.movie = movie;
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

        public Builder setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder copy(Ticket ticket) {
            this.ticketID = ticket.ticketID;
            this.movie = ticket.movie;
            this.theatre = ticket.theatre;
            this.cinema = ticket.cinema;
            this.ticketPrice = ticket.ticketPrice;
            this.date = ticket.date;
            this.time = ticket.time;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}

