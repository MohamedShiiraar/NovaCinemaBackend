package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Movie;

import java.util.Set;

public interface IMovieService extends IService<Movie,String> {
    Set<Movie> getall();
}
