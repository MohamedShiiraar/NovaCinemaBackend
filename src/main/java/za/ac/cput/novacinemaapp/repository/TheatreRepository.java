package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Theatre;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String> {
    List<Theatre> findAllBy(String theatreID);
}
