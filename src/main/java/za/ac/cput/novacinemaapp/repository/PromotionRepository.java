package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findPromotionByPromotionID(Long promotionID);
}
