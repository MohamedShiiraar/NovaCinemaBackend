package za.ac.cput.novacinemaapp.service;


import za.ac.cput.novacinemaapp.domain.User;

import java.util.Set;

public interface IUserService extends IService<User,String> {
    Set<User> getall ();
}
