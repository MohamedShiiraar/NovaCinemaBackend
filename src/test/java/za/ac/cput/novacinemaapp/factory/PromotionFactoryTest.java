package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.novacinemaapp.domain.Promotion;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PromotionFactoryTest {

    @Test
    @Order(1)
    void testBuildPromotion() {
        Promotion promotion = PromotionFactory.buildPromotion("Student Discount","Get 20% off on all movie tickets with your student ID",0.20f, LocalDateTime.parse("2024-08-29T00:00:00"),LocalDateTime.now());
        assertNotNull(promotion);
        System.out.println(promotion);
    }
}