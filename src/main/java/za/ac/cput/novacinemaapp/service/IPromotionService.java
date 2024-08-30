package za.ac.cput.novacinemaapp.service;


import za.ac.cput.novacinemaapp.domain.Promotion;

import java.util.Set;

public interface IPromotionService extends IService<Promotion, Long>{
    Set<Promotion> getAll();
}
