package za.ac.cput.novacinemaapp.service;
/*
IService for User
Author : Mohamed Shiiraar (220354804)
Date : 19 May
 */


import za.ac.cput.novacinemaapp.domain.User;

import java.util.Set;

public interface IUserService extends IService<User,String> {
    Set<User> getAll ();
}
