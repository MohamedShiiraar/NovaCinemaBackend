package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Cart {
    @Id
    private String cartID;

    @ManyToOne
    private User userID;

    @ManyToOne
    private Ticket ticketID;

    private String quantity;

    public Cart() {
    }

    public Cart(Builder builder) {
        this.cartID = builder.cartID;
        this.userID = builder.userID;
        this.ticketID = builder.ticketID;
        this.quantity = builder.quantity;
    }

    public String getCartID() {
        return cartID;
    }

    public User getUserID() {
        return userID;
    }

    public Ticket getTicketID() {
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
                "cartID='" + cartID + '\'' +
                ", userID=" + userID +
                ", ticketID=" + ticketID +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public static class Builder {
        private String cartID;
        private User userID;
        private Ticket ticketID;
        private String quantity;

        public Builder setCartID(String cartID) {
            this.cartID = cartID;
            return this;
        }

        public Builder setUserID(User userID) {
            this.userID = userID;
            return this;
        }

        public Builder setTicketID(Ticket ticketID) {
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
