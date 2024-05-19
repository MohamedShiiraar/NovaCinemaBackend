package za.ac.cput.novacinemaapp.service;
import za.ac.cput.novacinemaapp.domain.Showtime;
import java.util.List;

/*  IShowtimeService.java
 *   Service Interface for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   19 May 2024
 * */

public interface IShowtimeService extends IService<Showtime, String> {
    List<Showtime> getall();

}
