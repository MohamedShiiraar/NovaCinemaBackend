package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Cinema;

import java.util.Set;

public interface ICinemaService extends IService<Cinema, String>{
    Set<Cinema> getAll();
}
