package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.factory.CartFactory;
import za.ac.cput.novacinemaapp.factory.UserFactory;
import za.ac.cput.novacinemaapp.factory.TicketFactory;

import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartServiceTest {

    @Autowired
    private CartService cartService;

    private static Cart cart1, cart2;
    private static User user1, user2;
    private static Ticket ticket1, ticket2;

    @Test
    @Order(1)
    void setUp() {
        user1 = UserFactory.buildUser("1", "Amaan", "Allie", "Amaan.Allie@example.com", "password123");
        assertNotNull(user1);
        System.out.println(user1);

        user2 = UserFactory.buildUser("2", "Adam", "Mohamed", "adam.mohamed@example.com", "password456");
        assertNotNull(user2);
        System.out.println(user2);

        ticket1 = TicketFactory.buildTicket("1", "Movie1", LocalTime.of(18, 0), "A1", "Cinema1", 10.00);
        assertNotNull(ticket1);
        System.out.println(ticket1);

        ticket2 = TicketFactory.buildTicket("2", "Movie2", LocalTime.of(19, 0), "B2", "Cinema2", 12.00);
        assertNotNull(ticket2);
        System.out.println(ticket2);

        cart1 = CartFactory.buildCart(user1, ticket1, "2");
        assertNotNull(cart1);
        System.out.println(cart1);

        cart2 = CartFactory.buildCart(user2, ticket2, "3");
        assertNotNull(cart2);
        System.out.println(cart2);
    }

    @Test
    @Order(2)
    void create() {
        Cart created1 = cartService.create(cart1);
        assertNotNull(created1);
        System.out.println(created1);

        Cart created2 = cartService.create(cart2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Cart read = cartService.read(cart1.getCartID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Cart updatedCart = new Cart.Builder().copy(cart2).setQuantity("4").build();
        Cart updated = cartService.update(updatedCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        Set<Cart> carts = cartService.getAll();
        assertNotNull(carts);
        System.out.println(carts);
    }
}

