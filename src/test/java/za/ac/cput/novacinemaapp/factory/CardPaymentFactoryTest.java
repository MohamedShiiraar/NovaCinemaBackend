package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.domain.CardPayment;


import static org.junit.jupiter.api.Assertions.*;

class CardPaymentFactoryTest {

    @Test
    void testBuildCardPayment() {
        Card a = CardFactory.buildCard("Mohamed Shiiraar",903489764,"01/25");
        assertNotNull(a);
        CardPayment cardPayment = CardPaymentFactory.buildCardPayment(a, 1500.00);
        assertNotNull(cardPayment);
        System.out.println(cardPayment.toString());
    }

    @Test
    void testBuildCardPaymentWithFail() {
        CardPayment cardPayment = CardPaymentFactory.buildCardPayment(null, 1500.00);
        assertNotNull(cardPayment);
        System.out.println(cardPayment.toString());
    }
}