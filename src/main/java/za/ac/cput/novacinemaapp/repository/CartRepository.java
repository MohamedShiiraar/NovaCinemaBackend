package za.ac.cput.novacinemaapp.repository;

// Repository for Cart
// Author Amaan Allie
// 27 August 2024

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Cart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    List<Cart> findCartByCartID(String cartID);
}

