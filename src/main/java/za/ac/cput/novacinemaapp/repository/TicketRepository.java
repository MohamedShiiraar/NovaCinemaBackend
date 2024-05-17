package za.ac.cput.novacinemaapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String>{
    List<Ticket> findTicketByTicketID(String ticketId);
}

