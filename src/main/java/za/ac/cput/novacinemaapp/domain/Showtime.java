package za.ac.cput.novacinemaapp.domain;

/*  Showtime.java
 *   Domain class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Showtime {
    @Id
    private int showtimeId;
    private LocalDateTime showtime;
    private LocalDateTime endTime;

    @OneToOne
    @JoinColumn(name = "movie_Showtime")
    private Movie movie;
    @OneToOne
    @JoinColumn(name = "showtime_Showtime")
    private Showtime nextShow;

    public Showtime() {
    }

    public Showtime(Builder builder) {
        this.showtimeId = builder.showtimeId;
        this.showtime = builder.showtime;
        this.endTime = builder.endTime;
        this.movie = builder.movie;
        this.nextShow = builder.nextShow;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public LocalDateTime getShowtime() {
        return showtime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Showtime getNextShow() {
        return nextShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime1 = (Showtime) o;
        return getShowtimeId() == showtime1.getShowtimeId() && Objects.equals(getShowtime(), showtime1.getShowtime()) && Objects.equals(getEndTime(), showtime1.getEndTime()) && Objects.equals(getMovie(), showtime1.getMovie()) && Objects.equals(getNextShow(), showtime1.getNextShow());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShowtimeId(), getShowtime(), getEndTime(), getMovie(), getNextShow());
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "showtimeId=" + showtimeId +
                ", showtime=" + showtime +
                ", endTime=" + endTime +
                ", movie=" + movie +
                ", nextShow=" + nextShow +
                '}';
    }

    public static class Builder {

        private int showtimeId;
        private LocalDateTime showtime;
        private LocalDateTime endTime;
        private Movie movie;
        private Showtime nextShow;

        public Builder setShowtimeId(int showtimeId) {
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

        public Builder setNextShow(Showtime nextShow) {
            this.nextShow = nextShow;
            return this;
        }

        public Builder copy(Showtime showtime) {
            this.showtimeId = showtime.showtimeId;
            this.showtime = showtime.showtime;
            this.endTime = showtime.endTime;
            this.movie = showtime.movie;
            this.nextShow = showtime.nextShow;
            return this;
        }

        public Showtime build() { return new Showtime(this); }

    }
}
