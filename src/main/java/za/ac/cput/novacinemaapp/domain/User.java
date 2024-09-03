package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Objects;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String name;
    private String surname;
    private String emailAddress;
    private String password;
    private boolean isAdmin;

    public User() {
    }

    public User(Builder builder) {
        this.userID =builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.isAdmin = builder.isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID && isAdmin == user.isAdmin && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, surname, emailAddress, password, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public static class Builder{
        private long userID;
        private String name;
        private String surname;
        private String emailAddress;
        private String password;
        private boolean isAdmin;

        public Builder setUserID(long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.userID;
            this.name = user.name;
            this.surname = user.surname;
            this.emailAddress = user.emailAddress;
            this.password = user.password;
            this.isAdmin = user.isAdmin;
            return this;
        }
        public User build() {
            return new User(this);
        }
        }


}
