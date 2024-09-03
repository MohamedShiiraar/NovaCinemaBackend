package za.ac.cput.novacinemaapp.factory;

//Gammaad Mohamed
//220208344

import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.util.Helper;

public class GenreFactory {

    public static Genre buildGenre(String name, String description) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description))
            return null;

        return new Genre.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }
}
