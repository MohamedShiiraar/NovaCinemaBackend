package za.ac.cput.novacinemaapp.domain;

/*  Showtime.java
 *   Entity for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;
    private LocalDateTime showtime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Showtime() {
    }

    public Showtime(Builder builder) {
        this.showtimeId = builder.showtimeId;
        this.showtime = builder.showtime;
        this.endTime = builder.endTime;
        this.movie = builder.movie;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime1 = (Showtime) o;
        return Objects.equals(showtimeId, showtime1.showtimeId) && Objects.equals(showtime, showtime1.showtime) && Objects.equals(endTime, showtime1.endTime) && Objects.equals(movie, showtime1.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showtimeId, showtime, endTime, movie);
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

        private Long showtimeId;
        private LocalDateTime showtime;
        private LocalDateTime endTime;
        private Movie movie;

        public Builder setShowtimeId(Long showtimeId) {
            this.showtimeId = showtimeId;
            return this;
        }

        public Builder setShowtime(LocalDateTime showtime) {
            this.showtime = showtime;
            return this;
        }

        public Builder setEndTime(LocalDateTime endTime) {
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
