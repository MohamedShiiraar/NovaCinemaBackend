package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.util.Helper;

public class CinemaFactory {
    public static Cinema buildCinema(String name) {
        if (Helper.isNullOrEmpty(name))
            return null;

        return new Cinema.Builder()
                .setName(name)
                .build();
    }
}