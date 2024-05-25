package za.ac.cput.novacinemaapp.controller;
/*
Controller for Movie
Author : Mohamed Shiiraar 220354804
Date : 25 May
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.service.MovieService;

import java.util.Set;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie movie) {
        Movie createdMovie = movieService.create(movie);
        if (createdMovie == null) {
            return ResponseEntity.badRequest().body("Error creating a movie.Please try again later.");
        }
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id)  {
        Movie movie = movieService.read(id);
        if (movie == null) {
            return ResponseEntity.badRequest().body("Movie with id "+ id + " not found.");
        }
        return ResponseEntity.ok(movie);
    }
    @GetMapping("/getAll")
    public Set<Movie> getAll() {
        return movieService.getall();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.update(movie);
        if (updatedMovie == null) {
            return ResponseEntity.badRequest().body("Error updating movie.Please try again later.");
        }
        return ResponseEntity.ok(updatedMovie);
    }
}
