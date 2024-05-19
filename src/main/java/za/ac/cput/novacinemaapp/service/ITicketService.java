package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Ticket;
import java.util.Set;

public interface ITicketService extends IService<Ticket, String> {
    Set<Ticket> getall();
}
