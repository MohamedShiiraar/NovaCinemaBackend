package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Promotion;
import za.ac.cput.novacinemaapp.repository.PromotionRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromotionService implements IPromotionService{
    private final PromotionRepository repository;

    @Autowired
    PromotionService(PromotionRepository repository){this.repository = repository;}

    @Override
    public Set<Promotion> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Promotion create(Promotion promotion) {
        return repository.save(promotion);
    }

    @Override
    public Promotion read(Long promotionID) {
        return repository.findPromotionByPromotionID(promotionID);
    }

    @Override
    public Promotion update(Promotion promotion) {
        return repository.save(promotion);
    }
}
