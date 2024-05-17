package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.util.Helper;

public class CinemaFactory {
    public static Cinema buildCinema(String locationID, String name) {
        if (Helper.isNullOrEmpty(locationID) || Helper.isNullOrEmpty(name))
            return null;

        return new Cinema.Builder()
                .setLocationID(locationID)
                .setName(name)
                .build();
    }

    public static Cinema buildCinema(String name) {
        if (Helper.isNullOrEmpty(name))
            return null;

        String locationID = Helper.generateId();

        return new Cinema.Builder()
                .setLocationID(locationID)
                .setName(name)
                .build();
    }
}