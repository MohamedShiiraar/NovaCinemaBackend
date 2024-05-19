package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.factory.CardPaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CardPaymentServiceTest {
    @Autowired
    private CardPaymentService cardPaymentService;

    private static CardPayment cardPayment1, cardPayment2;

    @Test
    @Order(1)
    void setUp() {
        cardPayment1 = CardPaymentFactory.buildCardPayment("P123", "Moses Shire", 1234567812345678L, "12/25", 1500.00);
        assertNotNull(cardPayment1);
        System.out.println(cardPayment1);
        cardPayment2 = CardPaymentFactory.buildCardPayment("P124", "Steven Son", 1234567812345679L, "11/25", 2000.00);
        assertNotNull(cardPayment2);
        System.out.println(cardPayment2);
    }

    @Test
    @Order(2)
    void create() {
        CardPayment created1 = cardPaymentService.create(cardPayment1);
        assertNotNull(created1);
        System.out.println(created1);
        CardPayment created2 = cardPaymentService.create(cardPayment2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        CardPayment read = cardPaymentService.read(cardPayment1.getCardHolder());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        CardPayment newCardPayment = new CardPayment.Builder().copy(cardPayment2).setCardHolder("Neva Barros").build();
        CardPayment updated = cardPaymentService.update(newCardPayment);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(cardPaymentService.getAll());
    }
}