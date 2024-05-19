package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.repository.CardPaymentRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */
@Service
public class CardPaymentService implements ICardPaymentService {
    private CardPaymentRepository repository;

    @Autowired
    CardPaymentService(CardPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public CardPayment create(CardPayment cardPayment) {
        return repository.save(cardPayment);
    }

    @Override
    public CardPayment read(String CardHolder) {
        return repository.findCardPaymentByCardHolder(CardHolder);
    }

    @Override
    public CardPayment update(CardPayment cardPayment) {
        return repository.save(cardPayment);
    }

    @Override
    public Set<CardPayment> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}