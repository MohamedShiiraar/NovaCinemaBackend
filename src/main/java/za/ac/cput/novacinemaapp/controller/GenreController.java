package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.service.GenreService;
//import za.ac.cput.novacinemaapp.domain.Genre;
//import za.ac.cput.novacinemaapp.service.GenreService;

import java.util.Set;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Genre genre) {
        Genre createdGenre = genreService.create(genre);
        if (createdGenre == null) {
            return ResponseEntity.badRequest().body("Error creating genre. Please try again later.");
        }
        return new ResponseEntity<>(createdGenre, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Genre genre = genreService.read(id);
        if (genre == null) {
            return ResponseEntity.badRequest().body("Genre with id " + id + " not found.");
        }
        return ResponseEntity.ok(genre);
    }

    @GetMapping("/getAll")
    public Set<Genre> getAll() {
        return genreService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Genre genre) {
        Genre updatedGenre = genreService.update(genre);
        if (updatedGenre == null) {
            return ResponseEntity.badRequest().body("Error updating genre. Please try again later.");
        }
        return ResponseEntity.ok(updatedGenre);
    }
}

