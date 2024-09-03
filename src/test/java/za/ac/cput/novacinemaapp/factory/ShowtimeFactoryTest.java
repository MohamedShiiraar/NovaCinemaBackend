package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.MethodOrderer;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalTime;

/*  ShowtimeFactoryTest.java
 *   FactoryTest class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShowtimeFactoryTest {

    @Test
    @Order(1)
    void testBuildShowtime(){
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Showtime showtime = ShowtimeFactory.buildShowtime( LocalTime.of(10, 0), LocalTime.of(12, 0), b);
        assertNotNull(showtime);
        System.out.println(showtime);
    }

    @Test
    @Order(2)
    void testFail(){
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        Showtime showtime = ShowtimeFactory.buildShowtime(LocalTime.of(10, 0), LocalTime.of(12, 0), null);
        assertNotNull(showtime);
        System.out.println(showtime);
    }

}