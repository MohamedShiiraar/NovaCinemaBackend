package za.ac.cput.novacinemaapp.service;

//Gammaad Mohamed
//220208344

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.factory.GenreFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenreServiceTest {

    @Autowired
    private GenreService genreService;

    private static Genre genre1, genre2;

    @Test
    @Order(1)
    void setup() {
        genre1 = GenreFactory.buildGenre( "Action", "Movies that are characterized by intense, exciting sequences.");
        assertNotNull(genre1);
        System.out.println(genre1);

        genre2 = GenreFactory.buildGenre( "Drama", "Movies that focus on emotional themes and character development.");
        assertNotNull(genre2);
        System.out.println(genre2);
    }

    @Test
    @Order(2)
    void create() {
        Genre create1 = genreService.create(genre1);
        assertNotNull(create1);
        System.out.println(create1);

        Genre create2 = genreService.create(genre2);
        assertNotNull(create2);
        System.out.println(create2);
    }

    @Test
    @Order(3)
    void update() {
        Genre updated1 = new Genre.Builder().copy(genre2).setDescription("Updated description for Drama").build();
        Genre updated = genreService.update(updated1);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void read() {
        Genre read = genreService.read(genre1.getGenreID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(genreService.getAll());
    }

    @Test
    @Order(6)
    void findByName() {
        Set<Genre> found = genreService.findByName(genre2.getName());
        assertFalse(found.isEmpty());
        System.out.println(found);
    }
}
