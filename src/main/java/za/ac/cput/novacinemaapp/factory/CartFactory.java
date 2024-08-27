package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.domain.Ticket;
import za.ac.cput.novacinemaapp.util.Helper;

public class CartFactory {

    public static Cart buildCart(String cartID, User userID, Ticket ticketID, String quantity) {
        if (Helper.isNullOrEmpty(cartID) || userID == null || ticketID == null || Helper.isNullOrEmpty(quantity))
            return null;

        return new Cart.Builder()
                .setCartID(cartID)
                .setUserID(userID)
                .setTicketID(ticketID)
                .setQuantity(quantity)
                .build();
    }

    public static Cart buildCart(User userID, Ticket ticketID, String quantity) {
        if (userID == null || ticketID == null || Helper.isNullOrEmpty(quantity))
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


