package za.ac.cput.novacinemaapp.repository;

/*
GammaadMohamed-220208344
 */

import org.springframework.stereotype.Repository;
import za.ac.cput.novacinemaapp.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findNotificationByNotificationID(String notificationID);
}
