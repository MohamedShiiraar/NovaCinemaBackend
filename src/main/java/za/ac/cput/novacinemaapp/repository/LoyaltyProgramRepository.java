package za.ac.cput.novacinemaapp.repository;
//GammaadMohamed_220208344

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;

import java.util.List;

@Repository
public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram, String> {

    List<LoyaltyProgram> findLoyaltyProgramById(String id);


}
