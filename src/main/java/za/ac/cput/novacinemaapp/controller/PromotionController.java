package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Promotion;
import za.ac.cput.novacinemaapp.service.PromotionService;

import java.util.Set;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    PromotionService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Promotion promotion) {
        Promotion createdPromotion = service.create(promotion);
        if (createdPromotion == null) {
            return ResponseEntity.badRequest().body("Error creating a promotion. Please try again later.");
        }
        return new ResponseEntity<>(createdPromotion, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Promotion promotion = service.read(id);
        if (promotion == null) {
            return ResponseEntity.badRequest().body("Promotion with id " + id + " not found.");
        }
        return ResponseEntity.ok(promotion);
    }

    @GetMapping("/getAll")
    public Set<Promotion> getAll() {
        return service.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Promotion promotion) {
        Promotion updatedPromotion = service.update(promotion);
        if (updatedPromotion == null) {
            return ResponseEntity.badRequest().body("Error updating promotion. Please try again later.");
        }
        return ResponseEntity.ok(updatedPromotion);
    }
}
