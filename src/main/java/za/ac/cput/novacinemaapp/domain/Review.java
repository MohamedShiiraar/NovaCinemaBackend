package za.ac.cput.novacinemaapp.domain;

/*  Review.java
 *   Entity for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private double rating;
    private String comment;
    private LocalDate timestamp;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Review() {
    }

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.timestamp = builder.timestamp;
        this.movie = builder.movie;
        this.user = builder.user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Double.compare(rating, review.rating) == 0 && Objects.equals(reviewId, review.reviewId) && Objects.equals(comment, review.comment) && Objects.equals(timestamp, review.timestamp) && Objects.equals(movie, review.movie) && Objects.equals(user, review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, rating, comment, timestamp, movie, user);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                ", movie=" + movie +
                ", user=" + user +
                '}';
    }

    public static class Builder {

        private Long reviewId;
        private double rating;
        private String comment;
        private LocalDate timestamp;
        private Movie movie;
        private User user;

        public Builder setReviewId(Long reviewId) {
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

        public Builder setMovie(Movie movie) {
            this.movie = movie;
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
            this.movie = review.movie;
            this.user = review.user;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
