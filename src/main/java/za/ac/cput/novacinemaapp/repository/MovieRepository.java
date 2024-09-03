package za.ac.cput.novacinemaapp.repository;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findMovieByName(String name);
    List<Movie> findMoviesByGenre(Genre genre);
    List<Movie> findMoviesByAgeRestriction(String ageRestriction);
    void deleteMovieByName(String name);

}
