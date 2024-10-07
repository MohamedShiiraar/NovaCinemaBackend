package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Cart;
import java.util.Set;

// Author Amaan Allie
// 27 August 2024

public interface ICartService extends IService<Cart, String> {
    Set<Cart> getAll();
}

