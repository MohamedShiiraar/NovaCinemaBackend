package za.ac.cput.novacinemaapp.repository;
/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByUserID(Long userID);
    List<User> findUserByEmailAddress(String emailAddress);
    void deleteUserByEmailAddress(String emailAddress);


}
