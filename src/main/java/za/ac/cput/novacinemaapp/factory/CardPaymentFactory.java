package za.ac.cput.novacinemaapp.factory;


import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.util.Helper;

public class CardPaymentFactory {
    public static CardPayment buildCardPayment(String paymentID, String cardHolder, long cardNumber, String expiryDate, double amount) {
        if (Helper.isNullOrEmpty(paymentID) || Helper.isNullOrEmpty(cardHolder) || cardNumber <= 0 || Helper.isNullOrEmpty(expiryDate) || amount <= 0)
        return null;

        return new CardPayment.Builder()
                .setPaymentID(paymentID)
                .setCardHolder(cardHolder)
                .setCardNumber(cardNumber)
                .setExpiryDate(expiryDate)
                .setAmount(amount)
                .build();
    }

    public static CardPayment buildCardPayment(String cardHolder, long cardNumber, String expiryDate, double amount) {
        if (Helper.isNullOrEmpty(cardHolder) || cardNumber  <= 0 || Helper.isNullOrEmpty(expiryDate) || amount <= 0)
        return null;

        String paymentID = Helper.generateId();

        return new CardPayment.Builder()
                .setPaymentID(paymentID)
                .setCardHolder(cardHolder)
                .setCardNumber(cardNumber)
                .setExpiryDate(expiryDate)
                .setAmount(amount)
                .build();
    }
}