package za.ac.cput.novacinemaapp.repository;
    /*TheatreRepository.java
Entity for Theatre Repository
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Theatre;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre findTheatreByTheatreID(Long theatreID);
}
