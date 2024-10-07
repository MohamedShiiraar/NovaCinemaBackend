package za.ac.cput.novacinemaapp.service;
/*TheatreServiceTest.java
Entity for Theatre Service Test
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TheatreServiceTest {
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private CinemaService cinemaService;

    private static Theatre theatre1,theatre2;
    private static Cinema cinema;

    @Test
    @Order(1)
    void setUp() {
        cinema = CinemaFactory.buildCinema("Luxury Cinema", "Cape Town");
        cinemaService.create(cinema);
        theatre1 = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre1);
        System.out.println(theatre1);
        theatre2 = TheatreFactory.buildTheatre("2D",cinema);
        assertNotNull(theatre2);
        System.out.println(theatre2);
    }

    @Test
    @Order(2)
    void create() {
        Theatre created1 = theatreService.create(theatre1);
        assertNotNull(created1);
        System.out.println(created1);
        Theatre created2 = theatreService.create(theatre2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Theatre read = theatreService.read(theatre1.getTheatreID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Theatre newTheatre = new Theatre.Builder().copy(theatre2).setTheatreType("3D").build();
        Theatre updated = theatreService.update(newTheatre);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(theatreService.getAll());
    }
}