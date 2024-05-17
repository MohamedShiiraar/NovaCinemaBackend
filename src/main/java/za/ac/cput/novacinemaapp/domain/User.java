package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */
@Entity
public class User {
    @Id
    private String userID;
    private String name;
    private String surname;
    private String emailAddress;
    private String password;

    public User() {
    }

    public User(Builder builder) {
        this.userID =builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userID, user.userID) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, surname, emailAddress, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String userID;
        private String name;
        private String surname;
        private String emailAddress;
        private String password;

        public Builder setUserID(String userID) {
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

        public Builder copy(User user) {
            this.userID = user.userID;
            this.name = user.name;
            this.surname = user.surname;
            this.emailAddress = user.emailAddress;
            this.password = user.password;
            return this;
        }
        public User build() {
            return new User(this);
        }
        }


}
