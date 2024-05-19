package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.repository.TicketRepository;

import java.util.Set;
import java.util.stream.Collectors;

// Author Amaan Allie
// 19 May 2024

@Service
public class TicketService implements ITicketService {
    private final TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public Ticket read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<Ticket> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}

