package com.edugame.notification;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, NotificationID>{

	List<Notification> findByUsername(String username);

}
