package za.ac.cput.novacinemaapp.controller;

/*
ReviewController.java
Controller for Review
Author : Musaddiq McWhite (219369151)
Date : 25 May
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Review;
import za.ac.cput.novacinemaapp.repository.MovieRepository;
import za.ac.cput.novacinemaapp.repository.UserRepository;
import za.ac.cput.novacinemaapp.service.ReviewService;


import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Review review) {
        Review createdReview = reviewService.create(review);
        if (createdReview == null) {
            return ResponseEntity.badRequest().body("Error creating review. Please try again later.");
        }
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Review review = reviewService.read(id);
        if (review == null) {
            return ResponseEntity.badRequest().body("Review with id" + id + "not found.");
        }
        return ResponseEntity.ok(review);
    }

    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovieId(@PathVariable Long movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }

    @GetMapping("getAll")
    public Set<Review> getAll() {return reviewService.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Review review) {
        Review updatedReview = reviewService.update(review);
        if (updatedReview == null) {
            return ResponseEntity.badRequest().body("Error updating Review. Please try again later.");
        }
        return ResponseEntity.ok(updatedReview);
    }
}
