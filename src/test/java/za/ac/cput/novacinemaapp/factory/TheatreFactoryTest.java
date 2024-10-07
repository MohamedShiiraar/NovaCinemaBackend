package za.ac.cput.novacinemaapp.factory;
    /*TheatreFactoryTest.java
Entity for Theatre Factory test
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TheatreFactoryTest {
    @Test
    @Order(1)
    void testBuildTheatre(){
        Cinema cinema = CinemaFactory.buildCinema( "Grand Cinema", "Cape Town");
        Theatre theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        System.out.println(theatre);
    }
}