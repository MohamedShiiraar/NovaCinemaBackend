package za.ac.cput.novacinemaapp.controller;
/*
Controller for user
Author : Mohamed Shiiraar 220354804
Date : 25 May
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.service.UserService;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        System.out.println("Received user: " + user);
        if (createdUser == null) {
            return ResponseEntity.badRequest().body("Error creating a user.Please try again later.");
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        User user = userService.read(id);
        if (user == null) {
            return ResponseEntity.badRequest().body("User with id " + id + " not found.");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public Set<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        if (updatedUser == null){
            return ResponseEntity.badRequest().body("Error updating user.Please try again later");
        }
        return ResponseEntity.ok(updatedUser);
    }


}
