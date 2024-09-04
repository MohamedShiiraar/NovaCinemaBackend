package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.util.Helper;

public class CinemaFactory {
    public static Cinema buildCinema(String name, String address) {
        if (Helper.isNullOrEmpty(name) ||Helper.isNullOrEmpty(address) )
            return null;

        return new Cinema.Builder()
                .setName(name)
                .setAddress(address)
                .build();
    }
}