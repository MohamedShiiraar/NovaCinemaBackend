package za.ac.cput.novacinemaapp.domain;
import java.util.*;

public class CardPayment {
    private String paymentID;
    private String cardHolder;
    private long cardNumber;
    private String expiryDate;
    private double amount;

    public CardPayment() {
    }

    public CardPayment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.cardHolder = builder.cardHolder;
        this.cardNumber = builder.cardNumber;
        this.expiryDate = builder.expiryDate;
        this.amount = builder.amount;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof CardPayment)) return false;
        CardPayment that = (CardPayment) o;
        return cardNumber == that.cardNumber &&
        Double.compare(that.amount, amount) == 0 &&
        Objects.equals(paymentID, that.paymentID) &&
        Objects.equals(cardHolder, that.cardHolder) &&
        Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode(){
        return Objects.hash(paymentID, cardHolder, cardNumber, expiryDate, amount);
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "paymentID='" + paymentID + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", cardNumber=" + cardNumber +
                ", expiryDate='" + expiryDate + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static class Builder{
        private String paymentID;
        private String cardHolder;
        private long cardNumber;
        private String expiryDate;
        private double amount;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setCardHolder(String cardHolder) {
            this.cardHolder = cardHolder;
            return this;
        }

        public Builder setCardNumber(long cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(CardPayment cardPayment){
            this.paymentID = cardPayment.paymentID;
            this.cardHolder = cardPayment.cardHolder;
            this.cardNumber = cardPayment.cardNumber;
            this.expiryDate = cardPayment.expiryDate;
            this.amount = cardPayment.amount;
            return this;
        }

        public CardPayment build(){
            return new CardPayment(this);
        }
    }
}