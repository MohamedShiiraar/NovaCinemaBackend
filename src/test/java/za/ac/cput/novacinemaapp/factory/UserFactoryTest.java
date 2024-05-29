package za.ac.cput.novacinemaapp.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.novacinemaapp.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testBuildUser() {
        User b = UserFactory.buildUser("1","Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!");
        assertNotNull(b);
        System.out.println(b);
    }
    @Test
    void testBuildUserWithFail() {
        User c = UserFactory.buildUser("","Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!");
        assertNotNull(c);
        System.out.println(c.toString());
    }

}