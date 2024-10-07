package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cart;
import za.ac.cput.novacinemaapp.util.Helper;

public class CartFactory {

    public static Cart buildCart(String userID, String ticketID, String quantity) { // Keep parameters as String
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(ticketID) || Helper.isNullOrEmpty(quantity))
            return null;

        return new Cart.Builder()
                .setUserID(userID) // Directly set userID as String
                .setTicketID(ticketID) // Directly set ticketID as String
                .setQuantity(quantity)
                .build();
    }
}




