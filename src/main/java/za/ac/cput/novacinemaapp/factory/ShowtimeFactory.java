package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalDateTime;

/*  Showtime.java
 *   Factory class for Showtime
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */
public class ShowtimeFactory {

    public static Showtime buildShowtime(int showtimeId, LocalDateTime showtime, LocalDateTime endTime, Movie movie, Showtime nextShow) {
        if (Helper.isNullOrEmpty(showtimeId) || Helper.isNullOrEmpty(showtime) || Helper.isNullOrEmpty(endTime) || Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(nextShow))
            return null;

        return new Showtime.Builder().setShowtimeId(showtimeId).setShowtime(showtime)
                .setEndTime(endTime)
                .setMovie(movie)
                .setNextShow(nextShow)
                .build();
    }

    public static Showtime buildShowtime(LocalDateTime showtime, LocalDateTime endTime, Movie movie, Showtime nextShow) {
        if (Helper.isNullOrEmpty(showtime) || Helper.isNullOrEmpty(endTime) || Helper.isNullOrEmpty(movie) || Helper.isNullOrEmpty(nextShow))
            return null;

        int showtimeId = Integer.parseInt(Helper.generateId());

        return new Showtime.Builder().setShowtimeId(showtimeId).setShowtime(showtime)
                .setEndTime(endTime)
                .setMovie(movie)
                .setNextShow(nextShow)
                .build();
    }
}
