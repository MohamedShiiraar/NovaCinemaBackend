package za.ac.cput.novacinemaapp.service;

/*
GammaadMohamed-220208344
 */

import za.ac.cput.novacinemaapp.domain.Notification;

import java.util.Set;

public interface INotificationService {
    Notification create(Notification notification);
    Notification update(Notification notification);
    Notification read(Long id);
    Set<Notification> getAll();
}
