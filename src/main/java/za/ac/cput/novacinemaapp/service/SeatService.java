package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.repository.SeatRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*SeatRepository.java
Entity for Seat repository
Author: Daanyaal Isaacs (220094934)
Date: 17 May
*/
@Service
public class SeatService implements ISeatService{
    private SeatRepository repository;
    @Autowired
    SeatService(SeatRepository repository){
        this.repository = repository;
    }

    @Override
    public Seat create(Seat seat) {
        return repository.save(seat);
    }

    @Override
    public Seat read(String seatID) {
        return repository.findSeatBySeatID(seatID);
    }

    @Override
    public Seat update(Seat seat) {
        return repository.save(seat);
    }

    @Override
    public Set<Seat> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
