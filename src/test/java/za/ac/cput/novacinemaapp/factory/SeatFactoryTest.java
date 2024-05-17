package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.novacinemaapp.domain.Seat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeatFactoryTest {
    @Test
    @Order(1)
    void testBuildSeat(){
        Seat seat = SeatFactory.buildSeat("D4","Regular");
        assertNotNull(seat);
        System.out.println(seat.toString());
    }

    @Test
    @Order(2)
    void testFail(){
        Seat seat = SeatFactory.buildSeat("", "Regular");
        assertNotNull(seat);
        System.out.println(seat.toString());
    }
}