package za.ac.cput.novacinemaapp.service;

/*
GammaadMohamed-220208344
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.repository.NotificationRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService implements INotificationService {
    private final NotificationRepository repository;

    @Autowired
    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification create(Notification notification) {
        return repository.save(notification);
    }

    @Override
    public Notification update(Notification notification) {
        return repository.save(notification);
    }

    @Override
    public Notification read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Set<Notification> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
