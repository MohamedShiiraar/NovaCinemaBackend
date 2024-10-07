package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Ticket;
import java.util.Set;

// Author Amaan Allie
// 19 May 2024

public interface ITicketService extends IService<Ticket, String> {
    Set<Ticket> getAll();
}
