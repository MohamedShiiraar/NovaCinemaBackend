package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {
    List<Movie> findMovieBy(String name);
    List<Movie> findMoviesByGenre(String genre);
    List<Movie> findMoviesByAgeRestriction(String ageRestriction);
    void deleteMovieByName(String name);

}
