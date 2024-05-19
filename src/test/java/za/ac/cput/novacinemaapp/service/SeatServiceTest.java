package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.SeatFactory;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeatServiceTest {
    @Autowired
    private SeatService seatService;

    private static Seat seat1,seat2;
    private static Theatre theatre;
    private static Cinema cinema;

    @Test
    @Order(1)
    void setUp() {
        cinema = CinemaFactory.buildCinema("L123", "Grand Cinema");
        assertNotNull(cinema);
        theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        seat1 = SeatFactory.buildSeat("D1","Regular", theatre);
        assertNotNull(seat1);
        System.out.println(seat1);
        seat2 = SeatFactory.buildSeat("D3","Regular", theatre);
        assertNotNull(seat2);
        System.out.println(seat2);
    }
    @Test
    @Order(2)
    void create() {
        Seat created1 = seatService.create(seat1);
        assertNotNull(created1);
        System.out.println(created1);
        Seat created2 = seatService.create(seat2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Seat read = seatService.read(seat1.getSeatID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Seat newSeat = new Seat.Builder().copy(seat2).setSeatNumber("D2").build();
        Seat updated = seatService.update(newSeat);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(seatService.getAll());
    }
}