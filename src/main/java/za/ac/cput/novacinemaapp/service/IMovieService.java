package za.ac.cput.novacinemaapp.service;
/*
IService for Movie
Author : Mohamed Shiiraar (220354804)
Date : 19 May
 */

import za.ac.cput.novacinemaapp.domain.Movie;

import java.util.Set;

public interface IMovieService extends IService<Movie,Long> {
    Set<Movie> getall();
}
