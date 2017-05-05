package com.edugame.notification;

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
	@GetMapping("edugame/notifications/{username}")
	public void getUserNotifications(@PathVariable("username") String username)
	{
		notificationService.getUserNotification(username);
	}
}
