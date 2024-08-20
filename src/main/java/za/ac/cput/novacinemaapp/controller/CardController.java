package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.service.CardService;

import java.util.Set;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Card card) {
        Card createdCard = cardService.create(card);
        if (createdCard == null) {
            return ResponseEntity.badRequest().body("Error creating a new card entry.Please try again later.");

        }
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Card card = cardService.read(id);
        if (card == null) {
            return ResponseEntity.badRequest().body("Card with card id "+id+" not found.");
        }
        return ResponseEntity.ok(card);
    }

    @GetMapping("/getAll")
    public Set<Card> getAll() {
        return cardService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Card card) {
        Card updatedCard = cardService.update(card);
        if (updatedCard == null) {
            return ResponseEntity.badRequest().body("Error updating card.Please try again later.");
        }
        return ResponseEntity.ok(updatedCard);
    }

}
