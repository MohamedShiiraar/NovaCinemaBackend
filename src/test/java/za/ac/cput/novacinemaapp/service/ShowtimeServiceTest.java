package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;
import za.ac.cput.novacinemaapp.factory.ShowtimeFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/*  ShowtimeServiceTest.java
 *   ServiceTest class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   19 May 2024
 * */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShowtimeServiceTest {

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private MovieService movieService;

    private static Showtime showtime1, showtime2;
    private static Movie movie;

    @Test
    @Order(1)
    void setup() {
        showtime1 = ShowtimeFactory.buildShowtime("1", LocalTime.of(7, 0), LocalTime.of(9, 0), movie);
        assertNotNull(showtime1);
        System.out.println(showtime1);

        showtime2 = ShowtimeFactory.buildShowtime("2", LocalTime.of(8, 0), LocalTime.of(10, 0), movie);
        assertNotNull(showtime2);
        System.out.println(showtime2);
    }

    @Test
    @Order(2)
    void create() {
        Showtime create1 = showtimeService.create(showtime1);
        assertNotNull(create1);
        System.out.println(create1);

        Showtime create2 = showtimeService.create(showtime2);
        assertNotNull(create2);
        System.out.println(create2);

    }

    @Test
    @Order(3)
    void read() {
        Showtime read = showtimeService.read(showtime1.getShowtimeId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Showtime newUpdate = new Showtime.Builder().copy(showtime2).setShowtime(LocalTime.of(11, 0)).build();
        Showtime updated = showtimeService.update((newUpdate));
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getall() {System.out.println(showtimeService.getAll());}

}