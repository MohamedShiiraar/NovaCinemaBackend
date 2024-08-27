package za.ac.cput.novacinemaapp.factory;

// Factory for Cart
// Author Amaan Allie
// 27 August 2024

import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.util.Helper;

public class CartFactory {

    public static Cart buildCart(String cartID, String userID, String ticketID, String quantity) {
        if (Helper.isNullOrEmpty(cartID) || Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(quantity))
            return null;

        return new Cart.Builder()
                .setCartID(cartID)
                .setUserID(userID)
                .setTicketID(ticketID)
                .setQuantity(quantity)
                .build();
    }

    public static Cart buildCart(String userID, String ticketID, String quantity) {
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(quantity))
            return null;

        String cartID = Helper.generateId();

        return new Cart.Builder()
                .setCartID(cartID)
                .setUserID(userID)
                .setTicketID(ticketID)
                .setQuantity(quantity)
                .build();
    }
}

