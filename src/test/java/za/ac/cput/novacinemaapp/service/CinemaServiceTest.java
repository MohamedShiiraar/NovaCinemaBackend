package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CinemaServiceTest {
    @Autowired
    private CinemaService cinemaService;

    private static Cinema cinema1, cinema2;

    @Test
    @Order(1)
    void setUp() {
        cinema1 = CinemaFactory.buildCinema("L123", "Grand Cinema");
        assertNotNull(cinema1);
        System.out.println(cinema1);
        cinema2 = CinemaFactory.buildCinema("L124", "Luxury Cinema");
        assertNotNull(cinema2);
        System.out.println(cinema2);
    }

    @Test
    @Order(2)
    void create() {
        Cinema created1 = cinemaService.create(cinema1);
        assertNotNull(created1);
        System.out.println(created1);
        Cinema created2 = cinemaService.create(cinema2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Cinema read = cinemaService.read(cinema1.getLocationID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Cinema newCinema = new Cinema.Builder().copy(cinema2).setName("Grand Luxury Cinema").build();
        Cinema updated = cinemaService.update(newCinema);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(cinemaService.getAll());
    }
}