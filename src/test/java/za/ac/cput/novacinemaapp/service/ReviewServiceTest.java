package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.factory.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*  ReviewServiceTest.java
 *   ServiceTest class for Review
 *   Author: Musaddiq McWhite (219369151)
 *   19 May 2024
 * */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;
    private static Review review1, review2;
    private static Genre genre;
    private static Movie movie;
    private static User user1, user2;

    @Test
    @Order(1)
    void setup() {
        genre = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        genreService.create(genre);
        movie = MovieFactory.buildMovie( "Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", genre, "117 mins", "PG-13","imageURL");
        movieService.create(movie);

        user1 = UserFactory.buildUser("John","Doe","johndoe@gmail.com","johndoe123",false);
        userService.create(user1);
        user2 = UserFactory.buildUser("John","Doe","johndoe@gmail.com","johndoe123!",false);
        userService.create(user2);

        review1 = ReviewFactory.buildReview( 3.0, "Good experience!", LocalDate.of(2024, 5, 17),movie, user1);
        assertNotNull(review1);
        System.out.println(review1);

        review2 = ReviewFactory.buildReview( 4.5, "Great experience!", LocalDate.of(2024, 5, 17),movie, user2);
        assertNotNull(review2);
        System.out.println(review2);
    }

    @Test
    @Order(2)
    void create() {
        Review created1 = reviewService.create(review1);
        assertNotNull(created1);
        System.out.println(created1);

        Review created2 = reviewService.create(review2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Review read = reviewService.read(review1.getReviewId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Review newReview = new Review.Builder().copy(review2).setRating(5.0).build();
        Review updated = reviewService.update(newReview);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {System.out.println(reviewService.getAll());}

}