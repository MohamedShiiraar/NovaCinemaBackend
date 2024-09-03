package za.ac.cput.novacinemaapp.service;

//Gammaad Mohamed
//220208344

import za.ac.cput.novacinemaapp.domain.Genre;

import java.util.Set;

public interface IGenreService extends IService<Genre, Long>{

    Set<Genre> getAll();

    void deleteByName(String name);

    Set<Genre> findByName(String name);
}
