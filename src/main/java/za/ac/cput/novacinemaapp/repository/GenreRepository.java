package za.ac.cput.novacinemaapp.repository;

//Gammaad Mohamed
//220208344

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
    List<Genre> findGenreByName(String name);
    void deleteGenreByName(String name);
}
