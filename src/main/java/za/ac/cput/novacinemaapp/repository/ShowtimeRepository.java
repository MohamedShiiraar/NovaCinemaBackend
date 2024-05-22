package za.ac.cput.novacinemaapp.repository;

/*  ShowtimeRepository.java
 *   Interface for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,String> {

    List<Showtime> findShowtimeByMovie(Movie movie);

    Showtime findShowtimeByShowtimeId(String showtimeId);

    void deleteShowtimeByShowtimeId(String showtimeId);
}
