package za.ac.cput.novacinemaapp.repository;

/*  ReviewRepository.java
 *   Repository Interface for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.*;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Review findReviewByReviewId(Long reviewId);
    @Query("SELECT r FROM Review r WHERE r.movie.movieID = :movieId")
    List<Review> findByMovieId(@Param("movieId") Long movieId);
}
