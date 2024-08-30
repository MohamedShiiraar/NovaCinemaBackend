package za.ac.cput.novacinemaapp.factory;

// Test for TicketFactory
// Author Amaan Allie
// 17 May 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Ticket;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void testBuildTicket() {
        Ticket ticket = TicketFactory.buildTicket(Long.parseLong("1"), "Movie", LocalTime.of(18, 0), "A1", "Cinema", 10.00);
        assertNotNull(ticket);
        System.out.println(ticket.toString());
    }

    @Test
    void testBuildTicketWithFail() {
        Ticket ticket = TicketFactory.buildTicket(Long.parseLong(""), "Movie", LocalTime.of(18, 0), "A1", "Cinema", 10.00);
        assertNull(ticket);  // Changed to assertNull as the factory should return null for invalid input
    }
}
