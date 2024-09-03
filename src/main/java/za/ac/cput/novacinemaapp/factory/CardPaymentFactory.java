package za.ac.cput.novacinemaapp.factory;


import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.util.Helper;

public class CardPaymentFactory {
    public static CardPayment buildCardPayment(Card card, double amount) {
        if (Helper.isNullOrEmpty(card) || Helper.isNullOrEmpty(amount) || amount<0)
            return null;

    return new CardPayment.Builder().setCard(card)
        .setAmount(amount)
        .build();
    }
}