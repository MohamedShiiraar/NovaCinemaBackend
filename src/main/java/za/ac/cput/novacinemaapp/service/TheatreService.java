package za.ac.cput.novacinemaapp.service;
/*TheatreService.java
Entity for Theatre Service
Author: Daanyaal Isaacs (220094934)
Date: 19 May
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.repository.TheatreRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheatreService implements ITheatreService{
    private TheatreRepository repository;

    @Autowired
    TheatreService(TheatreRepository repository){
        this.repository = repository;
    }

    @Override
    public Theatre create(Theatre theatre) {
        return repository.save(theatre);
    }

    @Override
    public Theatre read(Long theatreID) {
        return repository.findTheatreByTheatreID(theatreID);
    }

    @Override
    public Theatre update(Theatre theatre) {
        return repository.save(theatre);
    }

    @Override
    public Set<Theatre> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
