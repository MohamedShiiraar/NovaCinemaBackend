package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Review;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.ReviewFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;

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
    private CinemaService cinemaService;
    @Autowired
    private UserService userService;
    private static Review review1, review2;
    private static Cinema cinema;
    private static User user;

    @Test
    @Order(1)
    void setup() {
        cinema = CinemaFactory.buildCinema("LT123", "Luxury Cinema");
        cinemaService.create(cinema);
        user = UserFactory.buildUser("1","Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!");
        userService.create(user);

        review1 = ReviewFactory.buildReview("10",cinema, user, 3.0, "Great experience!", LocalDate.now());
        assertNotNull(review1);
        System.out.println(review1);

        review2 = ReviewFactory.buildReview("11",cinema, user, 5.0, "Great experience!", LocalDate.now());
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