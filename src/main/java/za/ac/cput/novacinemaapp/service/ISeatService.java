package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Seat;

import java.util.Set;


public interface ISeatService extends IService<Seat, String>{
    Set<Seat> getAll();
}
