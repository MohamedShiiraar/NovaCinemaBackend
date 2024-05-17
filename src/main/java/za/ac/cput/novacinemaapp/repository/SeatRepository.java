package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Seat;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String>{
    List<Seat> findSeatBy(String seatId);
}
