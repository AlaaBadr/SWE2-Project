package com.edugame.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRep;

	public void getUserNotification(String username) {
		notificationRep.findByUsername(username);
	}

}
