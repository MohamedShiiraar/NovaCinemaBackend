package za.ac.cput.novacinemaapp.service;

/*
Service Test for Movie
Author : Mohamed Shiiraar (220354804)
Date : 19 May
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.factory.GenreFactory;
import za.ac.cput.novacinemaapp.factory.MovieFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieServiceTest {

    @Autowired
    private MovieService movieService;
    @Autowired
    private GenreService genreService;

    private static Genre genre1,genre2;
    private static Movie movie1,movie2;

    @Test
    @Order(1)
    void setup() {
        genre1 = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        genreService.create(genre1);
        movie1 = MovieFactory.buildMovie( "Cars", "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.", genre1, "117 mins", "PG-13","imageURL");
        assertNotNull(movie1);
        System.out.println(movie1);

        genre2 = GenreFactory.buildGenre( "Action", "Movies that are characterized by intense, exciting sequences.");
        genreService.create(genre2);
        movie2 = MovieFactory.buildMovie( "Transformers: Rise of the Beasts", "Optimus Prime and the Autobots team up with a down on his luck young man, an aspiring historian and with a powerful faction of Transformers known as the Maximals to combat a sinister force from outer space that threatens the Earth and all of mankind.", genre2, "127 mins", "PG-13","imageURL");
        assertNotNull(movie2);
        System.out.println(movie2);
    }
    @Test
    @Order(2)
    void create() {
        Movie create1 = movieService.create(movie1);
        assertNotNull(create1);
        System.out.println(create1);

        Movie create2 = movieService.create(movie2);
        assertNotNull(create2);
        System.out.println(create2);

    }
    @Test
    @Order(3)
    void update() {
        Movie updated1 = new Movie.Builder().copy(movie2).setDuration("128 mins").build();
        Movie updated = movieService.update(updated1);
        System.out.println(updated);

    }

    @Test
    @Order(4)
    void read () {
        Movie read = movieService.read(movie1.getMovieID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getall() {
        System.out.println(movieService.getall());

    }

}