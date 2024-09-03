package za.ac.cput.novacinemaapp.controller;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.service.CinemaService;

import java.util.Set;


@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    CinemaService cinemaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Cinema cinema) {
        Cinema createdCinema = cinemaService.create(cinema);
        if (createdCinema == null) {
            return ResponseEntity.badRequest().body("Error creating a cinema. Please try again later.");
        }
        return new ResponseEntity<>(createdCinema, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Cinema cinema = cinemaService.read(id);
        if (cinema == null) {
            return ResponseEntity.badRequest().body("Cinema with id " + id + " not found.");
        }
        return ResponseEntity.ok(cinema);
    }

    @GetMapping("/getAll")
    public Set<Cinema> getAll() {
        return cinemaService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Cinema cinema) {
        Cinema updatedCinema = cinemaService.update(cinema);
        if (updatedCinema == null) {
            return ResponseEntity.badRequest().body("Error updating cinema. Please try again later.");
        }
        return ResponseEntity.ok(updatedCinema);
    }
}