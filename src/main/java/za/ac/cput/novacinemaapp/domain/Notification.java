package za.ac.cput.novacinemaapp.domain;

/*
gammaadMohamed-220208344
 */

import jakarta.persistence.*;
import za.ac.cput.novacinemaapp.factory.LoyaltyProgramFactory;

import java.util.Objects;

@Entity
public class Notification {

    @Id
    private String notificationID;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    // Default constructor
    public Notification() {
    }

    // Constructor using builder
    public Notification(Builder builder) {
        this.notificationID = builder.notificationID;
        this.description = builder.description;
        this.user = builder.user;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(notificationID, that.notificationID) &&
                Objects.equals(description, that.description) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationID, description, user);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID='" + notificationID + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private String notificationID;
        private String description;
        private User user;

        public Builder setNotificationID(String notificationID) {
            this.notificationID = notificationID;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationID = notification.notificationID;
            this.description = notification.description;
            this.user = notification.user;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
