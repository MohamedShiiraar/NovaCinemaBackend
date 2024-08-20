package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.factory.CardFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardServiceTest {

    @Autowired
    private CardService cardService;

    private static Card card1,card2;

    @Test
    @Order(1)
    void setup() {
        card1 = CardFactory.buildCard("1","Mohamed Shiiraar",903489764,"01/25");
        assertNotNull(card1);
        System.out.println(card1);

        card2 = CardFactory.buildCard("2","Jared Barros",467984309,"01/26");
        assertNotNull(card2);
        System.out.println(card2);
    }

    @Test
    @Order(2)
    void create () {
        Card create1 = cardService.create(card1);
        assertNotNull(create1);
        System.out.println(create1);

        Card create2 = cardService.create(card2);
        assertNotNull(create2);
        System.out.println(create2);
    }

    @Test
    @Order(3)
    void update () {
        Card updated1 = new Card.Builder().copy(card2).setCardHolder("Gammaad Mohamed").build();
        Card updated = cardService.update(updated1);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void read() {
        Card read = cardService.read(card1.getCardID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getall() {
        System.out.println(cardService.getAll());
    }
}
