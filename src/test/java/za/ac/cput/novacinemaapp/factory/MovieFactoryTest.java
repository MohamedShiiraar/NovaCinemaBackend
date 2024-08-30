package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {
    @Test
    void testBuildMovie() {
        Movie b = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.","animation","117 mins","PG-13");
        assertNotNull(b);
        System.out.println(b.toString());
    }
    @Test
    void testBuildMovieWithFail() {
        Movie c = MovieFactory.buildMovie("Cars","After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.","animation","117 mins","PG-13");
        assertNotNull(c);
        System.out.println(c.toString());
    }

}