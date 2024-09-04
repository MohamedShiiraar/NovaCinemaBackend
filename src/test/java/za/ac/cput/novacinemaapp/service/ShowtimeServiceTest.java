package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;
import za.ac.cput.novacinemaapp.factory.GenreFactory;
import za.ac.cput.novacinemaapp.factory.MovieFactory;
import za.ac.cput.novacinemaapp.factory.ShowtimeFactory;

import java.time.LocalDateTime;
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
    @Autowired
    private GenreService genreService;
    private static Showtime showtime1, showtime2;
    private static Genre genre;
    private static Movie movie1, movie2;

    @Test
    @Order(1)
    void setup() {
    genre = GenreFactory.buildGenre( "Action", "Movies that are characterized by intense, exciting sequences.");
    movie1 = MovieFactory.buildMovie("Transformers: Rise of the Beasts", "Optimus Prime and the Autobots team up with a down on his luck young man, an aspiring historian and with a powerful faction of Transformers known as the Maximals to combat a sinister force from outer space that threatens the Earth and all of mankind.", genre, "127 mins", "PG-13","imageURL");
    movie2 = MovieFactory.buildMovie("Transformers: Rise of the Beasts", "Optimus Prime and the Autobots team up with a down on his luck young man, an aspiring historian and with a powerful faction of Transformers known as the Maximals to combat a sinister force from outer space that threatens the Earth and all of mankind.", genre, "127 mins", "PG-13","imageURL");
    genreService.create(genre);
    movieService.create(movie1);
    movieService.create(movie2);
    showtime1 = ShowtimeFactory.buildShowtime( LocalDateTime.parse("2024-08-29T00:00:00"), LocalDateTime.parse("2024-08-29T01:30:00"), movie1);
    assertNotNull(showtime1);
        System.out.println(showtime1);
    showtime2 = ShowtimeFactory.buildShowtime( LocalDateTime.parse("2024-08-30T00:00:00"), LocalDateTime.parse("2024-08-30T01:30:00"), movie2);
    assertNotNull(showtime2);
        System.out.println(showtime2);
    }

    @Test
    @Order(2)
    void create() {
       Showtime created1 = showtimeService.create(showtime1);
       assertNotNull(created1);
        System.out.println(created1);
       Showtime created2 = showtimeService.create(showtime2);
       assertNotNull(created2);
        System.out.println(created2);

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
        Showtime newShowtime = new Showtime.Builder().copy(showtime2).setShowtime(LocalDateTime.parse("2024-08-30T00:00:00")).setEndTime(LocalDateTime.parse("2024-08-30T01:30:00")).build();
        Showtime updated = showtimeService.update(newShowtime);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {System.out.println(showtimeService.getAll());}

}