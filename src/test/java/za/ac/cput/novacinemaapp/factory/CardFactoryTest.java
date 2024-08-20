package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.Card;

import static org.junit.jupiter.api.Assertions.*;


public class CardFactoryTest {
    @Test
    void testBuildCard() {
        Card a = CardFactory.buildCard("1","Mohamed Shiiraar",903489764,"01/25");
        assertNotNull(a);
        System.out.println(a);
    }

    @Test
    void testBuildCardwithFail () {
        Card b = CardFactory.buildCard("",903489764,"01/25");
        assertNotNull(b);
        System.out.println();
    }
}
