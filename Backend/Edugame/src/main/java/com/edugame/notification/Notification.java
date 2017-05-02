package com.edugame.notification;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.edugame.achievements.AchievementID;

@Entity
@Table(name = "notification")
@IdClass(NotificationID.class)
public class Notification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -394403912931803929L;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "notification")
	private String notification;
	
	@Column(name = "link")
	private String link;
	
	public Notification()
	{
		
	}

	public Notification(String username, String notification, String link) {
		super();
		this.username = username;
		this.notification = notification;
		this.link = link;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
