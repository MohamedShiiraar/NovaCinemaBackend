package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    List<User> findUserByUserID(String userID);
    List<User> findUserByEmailAddress(String emailAddress);
    void deleteUserByEmailAddress(String emailAddress);


}
