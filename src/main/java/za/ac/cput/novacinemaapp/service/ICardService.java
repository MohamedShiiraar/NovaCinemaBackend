package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Card;

import java.util.Set;

public interface ICardService extends IService<Card,Long>{
    Set<Card> getAll();
}
