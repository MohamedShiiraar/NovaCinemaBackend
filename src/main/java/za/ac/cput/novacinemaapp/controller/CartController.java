package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.service.CartService;

import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Cart cart) {
        Cart createdCart = cartService.create(cart);
        if (createdCart == null) {
            return ResponseEntity.badRequest().body("Error creating a cart. Please try again later.");
        }
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Cart cart = cartService.read(id);
        if (cart == null) {
            return ResponseEntity.badRequest().body("Cart with id " + id + " not found.");
        }
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/getAll")
    public Set<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Cart cart) {
        Cart updatedCart = cartService.update(cart);
        if (updatedCart == null) {
            return ResponseEntity.badRequest().body("Error updating cart. Please try again later.");
        }
        return ResponseEntity.ok(updatedCart);
    }
}

