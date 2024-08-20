package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Card;
import za.ac.cput.novacinemaapp.repository.CardRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CardService implements ICardService{
    private final CardRepository repository;

    @Autowired
    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Card> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Card create(Card card) {
        return repository.save(card);
    }

    @Override
    public Card read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Card update(Card card) {
        return repository.save(card);
    }
}
