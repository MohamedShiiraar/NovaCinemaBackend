package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;

import java.util.Set;

public interface  ILoyaltyProgramService extends IService<LoyaltyProgram, String> {
    Set<LoyaltyProgram> getall();



}
