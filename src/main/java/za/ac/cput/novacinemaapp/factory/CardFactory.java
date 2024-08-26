package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.util.Helper;

public class CardFactory {

    public static Card buildCard(String cardHolder,long cardNumber,String expiryDate) {
        if (Helper.isNullOrEmpty(cardHolder)||Helper.isNullOrEmpty(cardNumber) ||Helper.isNullOrEmpty(expiryDate))
            return null;

        String cardID = String.valueOf(Helper.generateId());

        return new Card.Builder().setCardID(cardID).setCardHolder(cardHolder).setCardNumber(cardNumber).setExpiryDate(expiryDate).build();
    }

    public static Card buildCard(String cardID,String cardHolder,long cardNumber,String expiryDate) {
        if (Helper.isNullOrEmpty(cardID)||Helper.isNullOrEmpty(cardHolder)||Helper.isNullOrEmpty(cardNumber) ||Helper.isNullOrEmpty(expiryDate))
            return null;


        return new Card.Builder().setCardID(cardID).setCardHolder(cardHolder).setCardNumber(cardNumber).setExpiryDate(expiryDate).build();
    }


}
