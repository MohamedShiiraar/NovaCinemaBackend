package za.ac.cput.novacinemaapp.controller;

/*
Gammaad Mohamed
220208344
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Notification;
import za.ac.cput.novacinemaapp.service.INotificationService;

import java.util.Set;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.create(notification);
        if (createdNotification == null) {
            return ResponseEntity.badRequest().body("Error creating notification. Please try again later.");
        }
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Notification notification = notificationService.read(id);
        if (notification == null) {
            return ResponseEntity.badRequest().body("Notification with id " + id + " not found.");
        }
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/getAll")
    public Set<Notification> getAll() {
        return notificationService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Notification notification) {
        Notification updatedNotification = notificationService.update(notification);
        if (updatedNotification == null) {
            return ResponseEntity.badRequest().body("Error updating notification. Please try again later.");
        }
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/delete/{recipient}")
    public ResponseEntity<?> deleteByRecipient(@PathVariable String recipient) {
        notificationService.deleteByRecipient(recipient);
        return ResponseEntity.ok("Notification(s) for recipient " + recipient + " deleted successfully.");
    }

    @GetMapping("/findByRecipient/{recipient}")
    public ResponseEntity<?> findByRecipient(@PathVariable String recipient) {
        Set<Notification> notifications = notificationService.findByRecipient(recipient);
        if (notifications.isEmpty()) {
            return ResponseEntity.badRequest().body("No notifications found for recipient " + recipient);
        }
        return ResponseEntity.ok(notifications);
    }
}
