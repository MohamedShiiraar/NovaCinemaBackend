package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Cinema;


import static org.junit.jupiter.api.Assertions.*;

class CinemaFactoryTest {

    @Test
    void testBuildCinema() {
        Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema");
        assertNotNull(cinema);
        System.out.println(cinema.toString());
    }

    @Test
    void testBuildCinemaWithFail() {
        Cinema cinema = CinemaFactory.buildCinema( "");
        assertNotNull(cinema);
        System.out.println(cinema.toString());
    }
}