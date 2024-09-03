package za.ac.cput.novacinemaapp.domain;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.*;
@Getter
@Entity
public class CardPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;
    @ManyToOne
    @JoinColumn(name = "Card_CardPayment")
    private Card card;
    private double amount;

    public CardPayment() {
    }

    public CardPayment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.card = builder.card;
        this.amount = builder.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardPayment that = (CardPayment) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(paymentID, that.paymentID) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, card, amount);
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "paymentID='" + paymentID + '\'' +
                ", card=" + card +
                ", amount=" + amount +
                '}';
    }

    public static class Builder{
        private Long paymentID;
        private Card card;
        private double amount;

        public Builder setPaymentID(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setCard(Card card) {
            this.card = card;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(CardPayment cardPayment){
            this.paymentID = cardPayment.paymentID;
            this.card = cardPayment.card;
            this.amount = cardPayment.amount;
            return this;
        }

        public CardPayment build(){
            return new CardPayment(this);
        }
    }
}