package za.ac.cput.novacinemaapp.factory;

//Gammaad Mohamed
//220208344

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Genre;

import static org.junit.jupiter.api.Assertions.*;

class GenreFactoryTest {

    @Test
    void testBuildGenre() {
        Genre g = GenreFactory.buildGenre( "Action", "Movies that are characterized by intense, exciting sequences.");
        assertNotNull(g);
        System.out.println(g.toString());
    }

    @Test
    void testBuildGenreFail() {
        Genre g = GenreFactory.buildGenre(null, "Movies that are characterized by intense, exciting sequences.");
        assertNotNull(g);
        System.out.println(g);
    }
}
