package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.util.Helper;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */
public class UserFactory {
    public static User buildUser(String userID, String name, String surname, String emailAddress, String password) {
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(password))
            return null;

        return new User.Builder().setUserID(userID).setName(name)
                .setSurname(surname)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }

    public static User buildUser(String name, String surname, String emailAddress, String password) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(password))
            return null;

        String userID = Helper.generateId();

        return new User.Builder().setUserID(userID).setName(name)
                .setSurname(surname)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }
}
