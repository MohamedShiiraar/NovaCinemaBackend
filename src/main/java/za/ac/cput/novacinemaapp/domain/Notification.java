package za.ac.cput.novacinemaapp.domain;

/*
gammaad mohamed
220208344
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Notification {
    @Id
    private String notificationID;
    private String message;
    private String recipient;

    public Notification() {
    }

    public Notification(Builder builder) {
        this.notificationID = builder.notificationID;
        this.message = builder.message;
        this.recipient = builder.recipient;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification notification)) return false;
        return Objects.equals(notificationID, notification.notificationID) &&
                Objects.equals(message, notification.message) &&
                Objects.equals(recipient, notification.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationID, message, recipient);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID='" + notificationID + '\'' +
                ", message='" + message + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }

    public static class Builder {
        private String notificationID;
        private String message;
        private String recipient;

        public Builder setNotificationID(String notificationID) {
            this.notificationID = notificationID;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationID = notification.notificationID;
            this.message = notification.message;
            this.recipient = notification.recipient;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
