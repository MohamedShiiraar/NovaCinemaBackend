package za.ac.cput.novacinemaapp.factory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import za.ac.cput.novacinemaapp.domain.*;
import za.ac.cput.novacinemaapp.util.Helper;

import java.util.Objects;

public class LoyaltyProgramFactory {
    public static LoyaltyProgram buildLoyaltyProgram(String id, String description, String rewards , String expirationPolicy, String signupBonus, String rules) {
        if (Helper.isNullOrEmpty(id) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(rewards) || Helper.isNullOrEmpty(expirationPolicy) ||Helper.isNullOrEmpty(signupBonus) || Helper.isNullOrEmpty(rules))
            return null;

        return new LoyaltyProgram.Builder()
                .setID(id)
                .setDescription(description)
                .setRewards(rewards)
                .setExpirationPolicy(expirationPolicy)
                .setSignupBonus(signupBonus)
                .setRules(rules)
                .build();
    }

    public static LoyaltyProgram buildLoyaltyProgram( String description, String rewards , String expirationPolicy, String signupBonus, String rules) {
        if ( Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(rewards) || Helper.isNullOrEmpty(expirationPolicy) ||Helper.isNullOrEmpty(signupBonus) || Helper.isNullOrEmpty(rules))
            return null;

        String id= Helper.generateId();
        return new LoyaltyProgram.Builder()
                .setID(id)
                .setDescription(description)
                .setRewards(rewards)
                .setExpirationPolicy(expirationPolicy)
                .setSignupBonus(signupBonus)
                .setRules(rules)
                .build();
    }

    @Entity
    public static class NotificationFactory {

        @Id
        private String notificationID;
        private String description;

        @ManyToOne
        @JoinColumn(name = "user_ID")
        private User user;

        public void Notification() {
        }

        public void Notification(Builder builder) {
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
            return Objects.equals(notificationID, that.getNotificationID()) &&
                    Objects.equals(description, that.getDescription()) &&
                    Objects.equals(user, that.getUser());
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
                this.notificationID = notification.getNotificationID();
                this.description = notification.getDescription();
                this.user = notification.getUser();
                return this;
            }

            public Notification build() {
                return new Notification(this);
            }
        }
    }
}