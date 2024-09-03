package za.ac.cput.novacinemaapp.service;

/*
Service for Genre
Author : [Your Name]
Date : [Current Date]
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Genre;
import za.ac.cput.novacinemaapp.repository.GenreRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService implements IGenreService {
    private final GenreRepository repository;

    @Autowired
    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Genre create(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public Genre read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<Genre> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteGenreByName(name);
    }

    @Override
    public Set<Genre> findByName(String name) {
        return repository.findGenreByName(name).stream().collect(Collectors.toSet());
    }
}
