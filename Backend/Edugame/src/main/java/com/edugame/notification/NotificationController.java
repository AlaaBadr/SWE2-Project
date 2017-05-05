package com.edugame.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@CrossOrigin()
	@GetMapping("/edugame/notifications/{username}")
	public List<Notification> getUserNotifications(@PathVariable("username") String username)
	{
		return notificationService.getUserNotification(username);
	}
}
