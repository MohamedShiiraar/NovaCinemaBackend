package za.ac.cput.novacinemaapp.controller;
/*
Controller for Movie
Author : Mohamed Shiiraar 220354804
Date : 25 May
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.service.MovieService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestParam("movieData") String movieData, @RequestParam("image") MultipartFile image) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(movieData, Movie.class);

            System.out.println("Received Movie Data: " + movieData);

            System.out.println(movie.getGenre());


            String imageUrl = saveImage(image);
            movie.setImageURL(imageUrl);


            Movie createdMovie = movieService.create(movie);
            return ResponseEntity.ok(createdMovie);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload or movie data parsing failed.");
        }
    }

    private String saveImage(MultipartFile image) throws IOException {

        String uploadDir = "src/main/resources/static/images/";
        File uploadDirectory = new File(uploadDir);

        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);


        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


        return "/images/" + fileName;
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable long id)  {
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
