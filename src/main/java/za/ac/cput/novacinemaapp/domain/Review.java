package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Review {
        @Id
        private int reviewId;
    @OneToOne
    @JoinColumn(name = "cinema_Review")
        private Cinema cinema;
    @OneToOne
    @JoinColumn(name = "user_Review")
        private User user;

        private double rating;
        private String comment;

        private LocalDateTime timestamp;


    public Review() {
    }

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.cinema = builder.cinema;
        this.user = builder.user;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.timestamp = builder.timestamp;
    }

    public int getReviewId() {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return getReviewId() == review.getReviewId() && Double.compare(getRating(), review.getRating()) == 0 && Objects.equals(getCinema(), review.getCinema()) && Objects.equals(getUser(), review.getUser()) && Objects.equals(getComment(), review.getComment()) && Objects.equals(getTimestamp(), review.getTimestamp());
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

    public void setReviewId(int reviewId) {
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

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static class Builder {

        private int reviewId;
        private Cinema cinema;
        private User user;
        private double rating;
        private String comment;

        private LocalDateTime timestamp;

        public Builder setReviewId(int reviewId) {
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

        public Builder setTimestamp(LocalDateTime timestamp) {
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
