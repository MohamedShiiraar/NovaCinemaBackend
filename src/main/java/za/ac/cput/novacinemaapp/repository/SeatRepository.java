package za.ac.cput.novacinemaapp.repository;
    /*SeatRepository.java
Entity for Seat repository
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Seat;

import java.util.List;
import java.util.Set;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String>{
    Seat findSeatBySeatID(String seatID);
}
