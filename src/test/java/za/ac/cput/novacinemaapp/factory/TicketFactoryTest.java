package za.ac.cput.novacinemaapp.factory;

// Entity for Ticket
// Author Amaan Allie
// 17 May 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void testBuildTicket() {
        Ticket ticket = TicketFactory.buildTicket("1", "Movie", "Theatre", "Cinema", 10.00, LocalDate.of(2024, 5, 17), LocalTime.of(18, 0));
        assertNotNull(ticket);
        System.out.println(ticket.toString());
    }

    @Test
    void testBuildTicketWithFail() {
        Ticket ticket = TicketFactory.buildTicket("", "Movie", "Theatre", "Cinema", 10.00, LocalDate.of(2024, 5, 17), LocalTime.of(18, 0));
        assertNotNull(ticket);
        System.out.println(ticket.toString());
    }
}