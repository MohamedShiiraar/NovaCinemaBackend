package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.Promotion;
import za.ac.cput.novacinemaapp.factory.PromotionFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PromotionServiceTest {
    @Autowired
    private PromotionService service;
    private static Promotion promotion,promotion2, created;

    @Test
    @Order(1)
    void setUp(){
        promotion = PromotionFactory.buildPromotion("Student Discount","Get 20% off on all movie tickets with your student ID",0.20f, LocalDateTime.parse("2024-08-29T00:00:00"),LocalDateTime.now());
        promotion2 = PromotionFactory.buildPromotion("Senior Citizen Offer","Enjoy special discounts for our senior moviegoers",0.25f, LocalDateTime.parse("2024-08-29T00:00:00"),LocalDateTime.now());
        assertNotNull(promotion);
        assertNotNull(promotion2);
        System.out.println(promotion);
        System.out.println(promotion2);
    }

    @Test
    @Order(2)
    void create() {
        created = service.create(promotion);
        assertNotNull(created);
        System.out.println(created);
        Promotion created2 = service.create(promotion2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void read() {
        Promotion read = service.read(created.getPromotionID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Promotion newPromotion = new Promotion.Builder().copy(created).setDiscountPercentage(0.30f).build();
        Promotion updated = service.update(newPromotion);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    @Order(5)
    void getAll() {
        System.out.println(service.getAll());
    }
}