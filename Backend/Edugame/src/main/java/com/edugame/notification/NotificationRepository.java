package com.edugame.notification;

import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, NotificationID>{

	void findByUsername(String username);

}
