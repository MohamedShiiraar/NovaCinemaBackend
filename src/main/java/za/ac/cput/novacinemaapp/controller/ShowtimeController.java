package za.ac.cput.novacinemaapp.controller;

/*
ShowtimeController.java
Controller for Showtime
Author : Musaddiq McWhite (219369151)
Date : 25 May
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Showtime;
import za.ac.cput.novacinemaapp.service.ShowtimeService;

import java.util.Set;
@RestController
@RequestMapping("Showtime")
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Showtime showtime) {
        Showtime createdShowtime = showtimeService.create(showtime);
        if (createdShowtime == null) {
            return ResponseEntity.badRequest().body("Error creating showtime. Please try again later.");
        }
        return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
    }

    @GetMapping("read/{showtimeId}")
    public ResponseEntity<?> get(@PathVariable Long showtimeId) {
        Showtime showtime = showtimeService.read(showtimeId);
        if (showtime == null) {
            return ResponseEntity.badRequest().body("Showtime with ShowtimeId" + showtimeId + "not found.");
        }
        return ResponseEntity.ok(showtime);
    }

    @GetMapping("getAll")
    public Set<Showtime> getAll() {return showtimeService.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Showtime showtime) {
        Showtime updatedShowtime = showtimeService.update(showtime);
        if (updatedShowtime == null) {
            return ResponseEntity.badRequest().body("Error updating showtime. Please try again later.");
        }
        return ResponseEntity.ok(updatedShowtime);
    }
}
