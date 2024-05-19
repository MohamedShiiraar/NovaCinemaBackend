package za.ac.cput.novacinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.CardPayment;

import java.util.List;

@Repository
public interface CardPaymentRepository extends JpaRepository<CardPayment,String> {
    List<CardPayment> findCardPaymentByCardNumber(long cardNumber);

    CardPayment findCardPaymentByCardHolder(String cardHolder);

    void deleteCardPaymentByCardNumber(long cardNumber);
}
