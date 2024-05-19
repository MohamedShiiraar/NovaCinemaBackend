package za.ac.cput.novacinemaapp.service;
//220208344_GammaadMohamed


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;
import za.ac.cput.novacinemaapp.repository.LoyaltyProgramRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoyaltyProgramService implements ILoyaltyProgramService {

    private final LoyaltyProgramRepository repository;

    @Autowired
    public LoyaltyProgramService(LoyaltyProgramRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoyaltyProgram create(LoyaltyProgram loyaltyProgram) {
        return repository.save(loyaltyProgram);
    }

    @Override
    public LoyaltyProgram update(LoyaltyProgram loyaltyProgram) {
        return repository.save(loyaltyProgram);
    }

    @Override
    public LoyaltyProgram read(String id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public Set<LoyaltyProgram> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }



    }

