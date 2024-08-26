package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    private static Ticket ticket1, ticket2;

    @Test
    @Order(1)
    void setUp() {
        ticket1 = TicketFactory.buildTicket("1", "Movie1", LocalTime.of(18, 0), "A1", "Cinema1", 10.00);
        assertNotNull(ticket1);
        System.out.println(ticket1);

        ticket2 = TicketFactory.buildTicket("2", "Movie2", LocalTime.of(19, 0), "B2", "Cinema2", 12.00);
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
        Ticket newTicket = new Ticket.Builder().copy(ticket2).setSeat("C3").build();
        Ticket updated = ticketService.update(newTicket);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        Set<Ticket> tickets = ticketService.getall();
        assertNotNull(tickets);
        System.out.println(tickets);
    }
}

