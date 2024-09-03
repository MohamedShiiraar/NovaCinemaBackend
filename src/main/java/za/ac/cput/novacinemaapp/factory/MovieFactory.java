package za.ac.cput.novacinemaapp.factory;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */

import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.util.Helper;

import java.sql.Blob;

public class MovieFactory {
    public static Movie buildMovie(String name, String movieDescription, Genre genre, String duration, String ageRestriction, String imageURL) {
        if ( Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(movieDescription) || Helper.isNullOrEmpty(genre) || Helper.isNullOrEmpty(duration) ||Helper.isNullOrEmpty(ageRestriction) )
            return null;

        return new Movie.Builder().setName(name)
                .setMovieDescription(movieDescription)
                .setGenre(genre)
                .setDuration(duration).setAgeRestriction(ageRestriction)
                .setImageURL(imageURL)
                .build();
    }
}
