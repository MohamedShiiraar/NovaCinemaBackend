package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.factory.CinemaFactory;
import za.ac.cput.novacinemaapp.factory.TheatreFactory;
import za.ac.cput.novacinemaapp.factory.TicketFactory;
import za.ac.cput.novacinemaapp.repository.TicketRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    private static Ticket ticket1, ticket2;
    private static Theatre theatre;
    private static Cinema cinema;

    @Test
    @Order(1)
    void setUp() {
        cinema = CinemaFactory.buildCinema("L123", "Grand Cinema");
        assertNotNull(cinema);
        theatre = TheatreFactory.buildTheatre("IMAX", cinema);
        assertNotNull(theatre);
        ticket1 = TicketFactory.buildTicket("T123", "Movie1", "Theatre1", "Cinema1", 10.00, LocalDate.of(2024, 5, 17), LocalTime.of(18, 0));
        assertNotNull(ticket1);
        System.out.println(ticket1);
        ticket2 = TicketFactory.buildTicket("T124", "Movie2", "Theatre2", "Cinema2", 10.00, LocalDate.of(2024, 5, 17), LocalTime.of(18, 0));
        assertNotNull(ticket2);
        System.out.println(ticket2);
    }

    @Test
    @Order(2)
    void create() {
        Ticket created1 = ticketService.create(ticket1);
        assertNotNull(created1);
        System.out.println(created1);
        Ticket created2 = ticketService.create(ticket2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Ticket read = ticketService.read(ticket1.getTicketID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Ticket newTicket = new Ticket.Builder().copy(ticket2).setMovie("UpdatedMovie2").build();
        Ticket updated = ticketService.update(newTicket);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(ticketService.getall());
    }
}
