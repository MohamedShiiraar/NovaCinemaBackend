package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Review;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDate;

/*  ReviewFactoryTest.java
 *   FactoryTest class for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewFactoryTest {

    @Test
    @Order(1)
    void testBuildReview(){
        User user = UserFactory.buildUser("1","john", "doe", "johndoe@gmail.com","johndoe123");
        assertNotNull(user);
        Cinema cinema = CinemaFactory.buildCinema("L123","CinemaX");
        assertNotNull(cinema);
        Review review = ReviewFactory.buildReview("9",cinema, user, 4.5, "Great experience!", LocalDate.now());
        assertNotNull(review);
        System.out.println(review);
    }

    @Test
    @Order(2)
    void testFail(){
        User user = UserFactory.buildUser("","john", "doe", "johndoe@gmail.com","johndoe123");
        assertNotNull(user);
        Cinema cinema = CinemaFactory.buildCinema("L123","CinemaX");
        assertNotNull(cinema);
        Review review = ReviewFactory.buildReview("", cinema, user, 4.5, "Great experience!", LocalDate.now());
        assertNotNull(review);
        System.out.println(review);
    }

}