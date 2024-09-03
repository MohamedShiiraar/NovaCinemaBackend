package za.ac.cput.novacinemaapp.service;

/*
Service Test for User
Author : Mohamed Shiiraar (220354804)
Date : 19 May
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static User user1,user2;

    @Test
    @Order(1)

    void setup() {
        user1 = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!",true);
        assertNotNull(user1);
        System.out.println(user1);

        user2 = UserFactory.buildUser("Daanyaal","Isaacs","daanyaalisaacs@gmail.com","Test123!",false);
        assertNotNull(user2);
        System.out.println(user2);

    }

    @Test
    @Order(2)
    void create() {
        User create1 = userService.create(user1);
        assertNotNull(create1);
        System.out.println(create1);

        User create2 = userService.create(user2);
        assertNotNull(create2);
        System.out.println(create2);
    }

    @Test
    @Order(3)
    void update () {
        User updated1 = new User.Builder().copy(user2).setName("Jared").setSurname("Barros").setEmailAddress("jared@gmail.com").build();
        User updated = userService.update(updated1);
        System.out.println(updated);

    }

    @Test
    @Order(4)
    void read() {
        User read = userService.read(user1.getUserID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void getall () {
        System.out.println(userService.getAll());
    }

}