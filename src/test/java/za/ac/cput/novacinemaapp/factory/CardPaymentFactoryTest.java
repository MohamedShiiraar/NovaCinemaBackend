package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.CardPayment;


import static org.junit.jupiter.api.Assertions.*;

class CardPaymentFactoryTest {

    @Test
    void testBuildCardPayment() {
        CardPayment cardPayment = CardPaymentFactory.buildCardPayment("P123", "Moses Shire", 12345678123456789L, "12/25", 1500.00);
        assertNotNull(cardPayment);
        System.out.println(cardPayment.toString());
    }

    @Test
    void testBuildCardPaymentWithFail() {
        CardPayment cardPayment = CardPaymentFactory.buildCardPayment("", "Moses Shire", 1234567812345678L, "12/25", 1500.00);
        assertNotNull(cardPayment);
        System.out.println(cardPayment.toString());
    }
}