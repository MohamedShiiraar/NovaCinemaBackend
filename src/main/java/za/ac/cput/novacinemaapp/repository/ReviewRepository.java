package za.ac.cput.novacinemaapp.repository;

/*  Showtime.java
 *   Domain class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.*;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {

    List<Review> findReviewByCinema(Cinema cinema);
    List<Review> findReviewByUser(User user);
    List<Review> findReviewByRating(double rating);

    List<Review> findReviewByTimestamp(LocalDateTime timestamp);

    void deleteReviewByReviewId(int reviewId);
}
