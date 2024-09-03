package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Review;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.util.Helper;
import java.time.LocalDate;

/*  ReviewFactory.java
 *   Factory class for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

public class ReviewFactory {

    public static Review buildReview(double rating, String comment, LocalDate timestamp, Movie movie, User user) {
        if (Helper.isNullOrEmpty(rating) || Helper.isNullOrEmpty(comment)
                || Helper.isNullOrEmpty(timestamp) || Helper.isNullOrEmpty(movie)
                || Helper.isNullOrEmpty(user))
            return null;

        return new Review.Builder().setRating(rating).setComment(comment).
                setTimestamp(timestamp).setMovie(movie).setUser(user)
                .build();
    }
}






