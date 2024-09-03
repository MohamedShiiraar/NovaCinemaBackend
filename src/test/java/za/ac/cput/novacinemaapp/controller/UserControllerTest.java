package za.ac.cput.novacinemaapp.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.factory.UserFactory;
import za.ac.cput.novacinemaapp.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    private static User user = UserFactory.buildUser("Mohamed","Shiiraar","mso2shiiraar@gmail.com","Test123!",false);

    private final String BASE_URL= "http://localhost:8080/user";

    private RestTemplate restTemplate = new RestTemplate();

    private static long userId;

    private HttpEntity<?>performPostRequest(Object object){
        return new HttpEntity<>(object);
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> userEntity = performPostRequest(user);
        String url = BASE_URL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url,userEntity,User.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        User savedUSer = postResponse.getBody();
        System.out.println("Saved data : " +savedUSer);
        assertNotNull(savedUSer);
        userId = savedUSer.getUserID();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + userId;
        System.out.println("URL: " + url);
        ResponseEntity<User> getResponse = restTemplate.exchange(RequestEntity.get(new URI(url)).build(),User.class);

        User readUser = getResponse.getBody();
        assertEquals(userId,readUser.getUserID());
        System.out.println("Read: "+readUser);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        User updatedUser = new User.Builder().copy(user).setSurname("Jordan").build();

        HttpEntity<?> entity = performPostRequest(updatedUser);

        System.out.println("URL: "+url);
        System.out.println("POST data: "+updatedUser);
        ResponseEntity<User> response = restTemplate.postForEntity(url,updatedUser,User.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + userId ;
        System.out.println("URL: " + url);

        HttpEntity<?> employeeEntity = performPostRequest(user);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, employeeEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

}
