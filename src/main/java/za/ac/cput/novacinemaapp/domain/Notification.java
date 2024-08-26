package za.ac.cput.novacinemaapp.domain;

/*
GammaadMohamed- 220208344
 */

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationID;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    public Notification() {}

    public Notification(Builder builder) {
        this.notificationID = builder.notificationID;
        this.description = builder.description;
        this.user = builder.user;
    }

    public Long getNotificationID() {
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
                "notificationID=" + notificationID +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private Long notificationID;
        private String description;
        private User user;

        public Builder setNotificationID(Long notificationID) {
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
