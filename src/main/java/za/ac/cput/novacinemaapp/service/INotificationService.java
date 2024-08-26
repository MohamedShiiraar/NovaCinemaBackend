package za.ac.cput.novacinemaapp.service;

/*
Interface for Notification Service
Author : [Your Name]
Date : [Current Date]
 */

import za.ac.cput.novacinemaapp.domain.Notification;

import java.util.Set;

public interface INotificationService {

    Notification create(Notification notification);

    Notification update(Notification notification);

    Notification read(String id);

    Set<Notification> getAll();

    void deleteByRecipient(String recipient);

    Set<Notification> findByRecipient(String recipient);
}
