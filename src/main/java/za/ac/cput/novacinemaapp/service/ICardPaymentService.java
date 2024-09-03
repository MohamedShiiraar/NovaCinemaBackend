package za.ac.cput.novacinemaapp.service;

import za.ac.cput.novacinemaapp.domain.CardPayment;

import java.util.Set;

/*
 * Jared Barros 219116962
 * 18/05/2024
 * */

public interface ICardPaymentService extends IService<CardPayment, Long>{
    Set<CardPayment> getAll();
}
