package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Cinema;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,String> {
    List<Cinema> findCinemaByLocationID(String locationID);
    List<Cinema> findCinemaByName(String Name);
}
