package za.ac.cput.novacinemaapp.service;
/*
Service for User
Author : Mohamed Shiiraar (220354804)
Date : 19 May
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }
    @Override
    public User update(User user) {
        return repository.save(user);
    }
    @Override
    public User read(Long s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Set<User> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
