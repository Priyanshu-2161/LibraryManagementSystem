package org.example.library.service;

import org.example.library.model.Member;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<String> notifications = new ArrayList<>();

    // Send a notification to a member
    public void sendNotification(Member member, String message) {

        if (member == null || message == null || message.isBlank()) {
            return;
        }

        String notification =
                "To: " + member.getName() + " (" + member.getEmail() + ") - " + message;

        notifications.add(notification);
    }

    // Get all notifications
    public List<String> getAllNotifications() {
        return new ArrayList<>(notifications);
    }

    // Send a due-date notification
    public void sendDueDateNotification(Member member, String dueDate) {

        String message = "Reminder: Your book is due on " + dueDate + ".";

        sendNotification(member, message);
    }

    // Send a new-arrival notification
    public void sendNewArrivalNotification(Member member, String bookTitle) {

        String message = "New book available: " + bookTitle;

        sendNotification(member, message);
    }
}