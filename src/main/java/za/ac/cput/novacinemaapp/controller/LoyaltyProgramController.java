package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;
import za.ac.cput.novacinemaapp.service.LoyaltyProgramService;

import java.util.Set;

@RestController
@RequestMapping("/loyalty-program")
public class LoyaltyProgramController {
    @Autowired
    LoyaltyProgramService loyaltyProgramService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LoyaltyProgram loyaltyProgram) {
        LoyaltyProgram createdLoyaltyProgram = loyaltyProgramService.create(loyaltyProgram);
        if (createdLoyaltyProgram == null) {
            return ResponseEntity.badRequest().body("Error creating a loyalty program. Please try again later.");
        }
        return new ResponseEntity<>(createdLoyaltyProgram, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id)  {
        LoyaltyProgram loyaltyProgram = loyaltyProgramService.read(id);
        if (loyaltyProgram == null) {
            return ResponseEntity.badRequest().body("Loyalty program with id "+ id + " not found.");
        }
        return ResponseEntity.ok(loyaltyProgram);
    }
    @GetMapping("/getAll")
    public Set<LoyaltyProgram> getAll() {
        return loyaltyProgramService.getall();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody LoyaltyProgram loyaltyProgram) {
        LoyaltyProgram updatedLoyaltyProgram = loyaltyProgramService.update(loyaltyProgram);
        if (updatedLoyaltyProgram == null) {
            return ResponseEntity.badRequest().body("Error updating loyalty program. Please try again later.");
        }
        return ResponseEntity.ok(updatedLoyaltyProgram);
    }
}
