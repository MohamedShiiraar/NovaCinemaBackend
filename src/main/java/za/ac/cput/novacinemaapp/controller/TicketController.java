package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.service.TicketService;

import java.util.Set;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.create(ticket);
        if (createdTicket == null) {
            return ResponseEntity.badRequest().body("Error creating a ticket. Please try again later.");
        }
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id)  {
        Ticket ticket = ticketService.read(id);
        if (ticket == null) {
            return ResponseEntity.badRequest().body("Ticket with id "+ id + " not found.");
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/getAll")
    public Set<Ticket> getAll() {
        return ticketService.getall();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.update(ticket);
        if (updatedTicket == null) {
            return ResponseEntity.badRequest().body("Error updating ticket. Please try again later.");
        }
        return ResponseEntity.ok(updatedTicket);
    }
}

