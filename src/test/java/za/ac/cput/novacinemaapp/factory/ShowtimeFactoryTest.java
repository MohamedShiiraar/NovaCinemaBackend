package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.MethodOrderer;
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
        Movie movie = MovieFactory.buildMovie("M001", "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "Science Fiction", "2h 28m", "PG-13");
        assertNotNull(movie);
        Showtime showtime = ShowtimeFactory.buildShowtime( "1",LocalTime.of(10, 0), LocalTime.of(12, 0), movie);
        assertNotNull(showtime);
        System.out.println(showtime);
    }

    @Test
    @Order(2)
    void testFail(){
        Movie movie = MovieFactory.buildMovie("", "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "Science Fiction", "2h 28m", "PG-13");
        assertNotNull(movie);
        Showtime showtime = ShowtimeFactory.buildShowtime("", LocalTime.of(10, 0), LocalTime.of(12, 0), movie);
        assertNotNull(showtime);
        System.out.println(showtime);
    }

}