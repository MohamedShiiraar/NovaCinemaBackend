package za.ac.cput.novacinemaapp.repository;
/*  Showtime.java
 *   Domain class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.Showtime;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,String> {
    List<Showtime> findShowtimeByShowtime(LocalDateTime showtime);
    List<Showtime> findShowtimeByEndTime(LocalDateTime endTime);
    List<Showtime> findShowtimeByMovie(Movie movie);

    void deleteShowtimeByShowtimeId(int showtimeId);
}
