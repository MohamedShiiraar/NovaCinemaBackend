package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {
    @Test
    void testBuildMovie() {
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(b);
        System.out.println(b.toString());
    }
    @Test
    void testBuildMovieWithFail() {
        Genre g = GenreFactory.buildGenre( "Animation", "Movies that are characterized by 2D or 3D graphics.");
        assertNotNull(g);
        Movie c = MovieFactory.buildMovie("","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",g,"117 mins","PG-13","imageURL");
        assertNotNull(c);
        System.out.println(c.toString());
    }

}