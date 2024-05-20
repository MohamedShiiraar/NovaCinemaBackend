package za.ac.cput.novacinemaapp.domain;

/*  Showtime.java
 *   Domain class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Showtime {
    @Id
    private String showtimeId;
    private LocalTime showtime;
    private LocalTime endTime;

    @OneToOne
    @JoinColumn(name = "Showtime_Movie")
    private Movie movie;

    public Showtime() {
    }

    public Showtime(Builder builder) {
        this.showtimeId = builder.showtimeId;
        this.showtime = builder.showtime;
        this.endTime = builder.endTime;
        this.movie = builder.movie;

    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public LocalTime getShowtime() {
        return showtime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime1 = (Showtime) o;
        return Objects.equals(getShowtimeId(), showtime1.getShowtimeId()) && Objects.equals(getShowtime(), showtime1.getShowtime()) && Objects.equals(getEndTime(), showtime1.getEndTime()) && Objects.equals(getMovie(), showtime1.getMovie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShowtimeId(), getShowtime(), getEndTime(), getMovie());
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "showtimeId=" + showtimeId +
                ", showtime=" + showtime +
                ", endTime=" + endTime +
                ", movie=" + movie +
                '}';
    }

    public static class Builder {

        private String showtimeId;
        private LocalTime showtime;
        private LocalTime endTime;
        private Movie movie;

        public Builder setShowtimeId(String showtimeId) {
            this.showtimeId = showtimeId;
            return this;
        }

        public Builder setShowtime(LocalTime showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }


        public Builder copy(Showtime showtime) {
            this.showtimeId = showtime.showtimeId;
            this.showtime = showtime.showtime;
            this.endTime = showtime.endTime;
            this.movie = showtime.movie;
            return this;
        }

        public Showtime build() { return new Showtime(this); }

    }
}
