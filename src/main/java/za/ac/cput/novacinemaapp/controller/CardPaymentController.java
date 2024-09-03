package za.ac.cput.novacinemaapp.controller;
/*
 * Jared Barros 219116962
 * 18/05/2024
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.service.CardPaymentService;

import java.util.Set;

@RestController
@RequestMapping("/cardpayment")
public class CardPaymentController {
    @Autowired
    CardPaymentService cardPaymentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CardPayment cardPayment) {
        CardPayment createdCardPayment = cardPaymentService.create(cardPayment);
        if (createdCardPayment == null) {
            return ResponseEntity.badRequest().body("Error creating a card payment. Please try again later.");
        }
        return new ResponseEntity<>(createdCardPayment, HttpStatus.CREATED);
    }

    @GetMapping("/read/{paymentID}")
    public ResponseEntity<?> get(@PathVariable Long paymentID) {
        CardPayment cardPayment = cardPaymentService.read(paymentID);
        if (cardPayment == null) {
            return ResponseEntity.badRequest().body("Card payment for Payment ID " + paymentID + " not found.");
        }
        return ResponseEntity.ok(cardPayment);
    }

    @GetMapping("/getAll")
    public Set<CardPayment> getAll() {
        return cardPaymentService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody CardPayment cardPayment) {
        CardPayment updatedCardPayment = cardPaymentService.update(cardPayment);
        if (updatedCardPayment == null) {
            return ResponseEntity.badRequest().body("Error updating card payment. Please try again later.");
        }
        return ResponseEntity.ok(updatedCardPayment);
    }
}

