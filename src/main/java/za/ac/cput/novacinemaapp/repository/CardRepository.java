package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,String> {
    Card findCardByCardID(String cardID);
    Card findCardByCardHolder(String cardHolder);
}
