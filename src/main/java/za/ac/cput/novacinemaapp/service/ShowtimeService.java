package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.repository.ShowtimeRepository;
import za.ac.cput.novacinemaapp.domain.Showtime;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowtimeService implements IShowtimeService {

    private ShowtimeRepository repository;

    @Autowired
    ShowtimeService(ShowtimeRepository repository) {this.repository = repository;}

    @Override
    public Showtime create(Showtime showtime) {return repository.save(showtime);}

    @Override
    public Showtime read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public Showtime update(Showtime showtime) {return repository.save(showtime);}

    @Override
    public Set<Showtime> getAll() {return repository.findAll().stream().collect(Collectors.toSet());}

}
