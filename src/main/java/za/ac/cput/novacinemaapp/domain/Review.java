package za.ac.cput.novacinemaapp.domain;

/*  Showtime.java
 *   Domain class for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Review {
    @Id
    private String reviewId;
    private double rating;
    private String comment;
    private LocalDate timestamp;
    @OneToOne
    @JoinColumn(name = "Review_Cinema")
    private Cinema cinema;
    @OneToOne
    @JoinColumn(name = "Review_User_")
    private User user;

    public Review() {
    }

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.timestamp = builder.timestamp;
        this.cinema = builder.cinema;
        this.user = builder.user;
    }

    public String getReviewId() {
        return reviewId;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public User getUser() {
        return user;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Double.compare(getRating(), review.getRating()) == 0 && Objects.equals(getReviewId(), review.getReviewId()) && Objects.equals(getCinema(), review.getCinema()) && Objects.equals(getUser(), review.getUser()) && Objects.equals(getComment(), review.getComment()) && Objects.equals(getTimestamp(), review.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), getCinema(), getUser(), getRating(), getComment(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", cinema=" + cinema +
                ", user=" + user +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public static class Builder {

        private String reviewId;
        private Cinema cinema;
        private User user;
        private double rating;
        private String comment;

        private LocalDate timestamp;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setCinema(Cinema cinema) {
            this.cinema = cinema;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setTimestamp(LocalDate timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.cinema = review.cinema;
            this.user = review.user;
            this.rating = review.rating;
            this.comment = review.comment;
            this.timestamp = review.timestamp;
            return this;
        }

        public Review build() { return new Review(this); }
    }
}
