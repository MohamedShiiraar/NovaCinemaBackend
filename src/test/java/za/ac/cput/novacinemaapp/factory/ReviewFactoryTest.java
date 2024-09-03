package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.*;

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
        User user = UserFactory.buildUser("john", "doe", "johndoe@gmail.com","johndoe123",false);
        assertNotNull(user);
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Review review = ReviewFactory.buildReview( 4.5, "Great experience!", LocalDate.now(),b, user);
        assertNotNull(review);
        System.out.println(review);
    }

    @Test
    @Order(2)
    void testFail(){
        User user = UserFactory.buildUser("john", "doe", "johndoe@gmail.com","johndoe123",false);
        assertNotNull(user);
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Review review = ReviewFactory.buildReview( 5.0, "Great experience!", null, b, user);
        assertNotNull(review);
        System.out.println(review);
    }

}