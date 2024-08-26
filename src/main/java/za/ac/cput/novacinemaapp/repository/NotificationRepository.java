package za.ac.cput.novacinemaapp.repository;

/*
GammaadMohamed-220208344
 */

import za.ac.cput.novacinemaapp.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, String> {
}
