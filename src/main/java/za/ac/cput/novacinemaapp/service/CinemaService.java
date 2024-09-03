package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.repository.CinemaRepository;

import java.util.Set;
import java.util.stream.Collectors;
/*
* Jared Barros 219116962
* 18/05/2024
* */
@Service
public class CinemaService implements ICinemaService {
    private CinemaRepository repository;

    @Autowired
    CinemaService(CinemaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cinema create(Cinema cinema) {
        return repository.save(cinema);
    }

    @Override
    public Cinema read(Long s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Cinema update(Cinema cinema) {
        return repository.save(cinema);
    }

    @Override
    public Set<Cinema> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}