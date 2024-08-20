package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Card {
    @Id
    private String cardID;
    private String cardHolder;
    private long cardNumber;
    private String expiryDate;

    public Card() {
    }

    public Card(Builder builder) {
        this.cardID = builder.cardID;
        this.cardHolder = builder.cardHolder;
        this.cardNumber = builder.cardNumber;
        this.expiryDate = builder.expiryDate;
    }

    public String getCardID() {
        return cardID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return cardNumber == card.cardNumber && Objects.equals(cardID, card.cardID) && Objects.equals(cardHolder, card.cardHolder) && Objects.equals(expiryDate, card.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardID, cardHolder, cardNumber, expiryDate);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardID='" + cardID + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", cardNumber=" + cardNumber +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }

    public static class Builder {
        private String cardID;
        private String cardHolder;
        private long cardNumber;
        private String expiryDate;

        public Builder setCardID(String cardID) {
            this.cardID = cardID;
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

        public Builder copy(Card card){
            this.cardID = card.cardID;
            this.cardHolder = card.cardHolder;
            this.cardNumber = card.cardNumber;
            this.expiryDate = card.expiryDate;
            return this;
        }
        public Card build() {
            return new Card(this);
        }
    }
}
