package za.ac.cput.novacinemaapp.factory;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */

import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.util.Helper;

public class MovieFactory {
    public static Movie buildMovie(String movieID, String name, String movieDescription, String genre, String duration,String ageRestriction) {
        if (Helper.isNullOrEmpty(movieID) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(movieDescription) || Helper.isNullOrEmpty(genre) || Helper.isNullOrEmpty(duration) ||Helper.isNullOrEmpty(ageRestriction))
            return null;

        return new Movie.Builder().setMovieID(movieID).setName(name)
                .setMovieDescription(movieDescription)
                .setGenre(genre)
                .setDuration(duration).setAgeRestriction(ageRestriction)
                .build();
    }

    public static Movie buildMovie(String name, String movieDescription, String genre, String duration,String ageRestriction) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(movieDescription) || Helper.isNullOrEmpty(genre) || Helper.isNullOrEmpty(duration) ||Helper.isNullOrEmpty(ageRestriction))
            return null;

        String movieID = Helper.generateId();

        return new Movie.Builder().setMovieID(movieID).setName(name)
                .setMovieDescription(movieDescription)
                .setGenre(genre)
                .setDuration(duration).setAgeRestriction(ageRestriction)
                .build();
    }





}
