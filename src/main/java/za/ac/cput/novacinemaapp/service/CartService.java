package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.repository.CartRepository;

import java.util.Set;
import java.util.stream.Collectors;

// Author Amaan Allie
// 27 August 2024

@Service
public class CartService implements ICartService {
    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<Cart> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}

