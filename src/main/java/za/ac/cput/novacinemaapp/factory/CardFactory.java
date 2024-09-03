package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.util.Helper;

public class CardFactory {

    public static Card buildCard(String cardHolder,long cardNumber,String expiryDate) {
        if (Helper.isNullOrEmpty(cardHolder)||Helper.isNullOrEmpty(cardNumber) ||Helper.isNullOrEmpty(expiryDate))
            return null;

        return new Card.Builder().setCardHolder(cardHolder).setCardNumber(cardNumber).setExpiryDate(expiryDate).build();
    }
}
