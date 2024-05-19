package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.Cinema;

import java.util.Set;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */

public interface ICinemaService extends IService<Cinema, String>{
    Set<Cinema> getAll();
}
