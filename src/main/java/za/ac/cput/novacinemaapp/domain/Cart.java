package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cartID; // Changed to String


    private String userID; // Changed to String


    private String ticketID; // Changed to String

    private String quantity;

    public Cart() {
    }

    public Cart(Builder builder) {
        this.cartID = builder.cartID;
        this.userID = builder.userID;
        this.ticketID = builder.ticketID;
        this.quantity = builder.quantity;
    }

    public String getCartID() { // Changed return type to String
        return cartID;
    }

    public String getUserID() { // Changed return type to String
        return userID;
    }

    public String getTicketID() { // Changed return type to String
        return ticketID;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(cartID, cart.cartID) &&
                Objects.equals(userID, cart.userID) &&
                Objects.equals(ticketID, cart.ticketID) &&
                Objects.equals(quantity, cart.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID, userID, ticketID, quantity);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID='" + cartID + '\'' + // Changed to String
                ", userID='" + userID + '\'' + // Changed to String
                ", ticketID='" + ticketID + '\'' + // Changed to String
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public static class Builder {
        private String cartID; // Changed to String
        private String userID; // Changed to String
        private String ticketID; // Changed to String
        private String quantity;

        public Builder setCartID(String cartID) { // Changed parameter type to String
            this.cartID = cartID;
            return this;
        }

        public Builder setUserID(String userID) { // Changed parameter type to String
            this.userID = userID;
            return this;
        }

        public Builder setTicketID(String ticketID) { // Changed parameter type to String
            this.ticketID = ticketID;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartID = cart.cartID;
            this.userID = cart.userID;
            this.ticketID = cart.ticketID;
            this.quantity = cart.quantity;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}


