package za.ac.cput.novacinemaapp.service;

/*
GammaadMohamed-220208344
 */

import za.ac.cput.novacinemaapp.domain.Notification;

import java.util.Set;

public interface INotificationService extends IService<Notification,String>{
    Set<Notification> getAll();
}
