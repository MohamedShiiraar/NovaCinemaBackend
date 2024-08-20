package za.ac.cput.novacinemaapp.domain;

/*  Review.java
 *   Entity for Review
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
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @OneToOne
    @JoinColumn(name = "user_id")
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

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewId, review.reviewId) && Double.compare(rating, review.rating) == 0 && Objects.equals(comment, review.comment) && Objects.equals(timestamp, review.timestamp) && Objects.equals(cinema, review.cinema) && Objects.equals(user, review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, rating, comment, timestamp, cinema, user);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                ", cinema=" + cinema +
                ", user=" + user +
                '}';
    }

    public static class Builder {

        private String reviewId;
        private double rating;
        private String comment;
        private LocalDate timestamp;
        private Cinema cinema;
        private User user;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
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

        public Builder setCinema(Cinema cinema) {
            this.cinema = cinema;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.rating = review.rating;
            this.comment = review.comment;
            this.timestamp = review.timestamp;
            this.cinema = review.cinema;
            this.user = review.user;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
