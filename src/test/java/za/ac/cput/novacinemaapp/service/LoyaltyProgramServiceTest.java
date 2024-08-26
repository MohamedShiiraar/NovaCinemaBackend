package za.ac.cput.novacinemaapp.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.NovaCinemaAppApplication;
import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;
import za.ac.cput.novacinemaapp.factory.LoyaltyProgramFactory;

import static org.junit.jupiter.api.Assertions.*;
//220208344_GammaadMohamed

@SpringBootTest(classes = NovaCinemaAppApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LoyaltyProgramServiceTest {


    /*@Autowired
    private LoyaltyProgramService loyaltyProgramService;
    private static LoyaltyProgram loyaltyProgram1,loyaltyProgram2;
    @Test
    @Order(1)
    void setup(){

        loyaltyProgram1 = LoyaltyProgramFactory.buildLoyaltyProgram("1", "20 points for purchasing a movie ticket", "20","30 December" ,"10","One user per account");
        assertNotNull(loyaltyProgram1);

        System.out.println(loyaltyProgram1);

        loyaltyProgram2 = LoyaltyProgramFactory.buildLoyaltyProgram("2", "40 points for purchasing a movie ticket", "40","30 December" ,"10","One user per account");
        assertNotNull(loyaltyProgram2);

        System.out.println(loyaltyProgram2);


    }
    @Test
    @Order(2)
    void create() {

        LoyaltyProgram created1 = loyaltyProgramService.create(loyaltyProgram1);
        assertNotNull(created1);
        System.out.println(created1);

        LoyaltyProgram created2 = loyaltyProgramService.create(loyaltyProgram2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void update() {

        LoyaltyProgram updated1 = new LoyaltyProgram.Builder().copy(loyaltyProgram2).setRewards("60").build();
        LoyaltyProgram updated =  loyaltyProgramService.update(updated1);
    }

    @Test
    @Order(4)
    void read() {
        LoyaltyProgram read = loyaltyProgramService.read(loyaltyProgram1.getId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getall() {
        System.out.println(loyaltyProgramService.getall());

    }*/
}