package za.ac.cput.novacinemaapp.factory;

// Test for CartFactory
// Author Amaan Allie
// 27 August 2024

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.factory.CartFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    private static final User user = UserFactory.buildUser("1", "Amaan", "Allie", "Amaan.Allie@example.com", "password123");
    private static final Ticket ticket = TicketFactory.buildTicket("1", "Movie", LocalTime.of(18, 0), "A1", "Cinema", 10.00);

    @Test
    void testBuildCart() {
        Cart cart = CartFactory.buildCart(user, ticket, "2");
        assertNotNull(cart);
        System.out.println(cart.toString());
    }

    @Test
    void testBuildCartWithFail() {
        Cart cart = CartFactory.buildCart(null, ticket, "2");
        assertNull(cart);

        cart = CartFactory.buildCart(user, null, "2");
        assertNull(cart);

        cart = CartFactory.buildCart(user, ticket, null);
        assertNull(cart);
    }
}
