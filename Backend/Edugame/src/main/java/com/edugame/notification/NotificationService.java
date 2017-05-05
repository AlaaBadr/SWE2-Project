package com.edugame.notification;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseRepository;
import com.edugame.game.Game;
import com.edugame.game.GameRepository;
import com.edugame.user.Student;
import com.edugame.user.Teacher;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRep;
	
	@Autowired
	private CourseRepository courseRep;

	@Autowired
	private GameRepository gameRep;
	
	public void getUserNotification(String username) {
		notificationRep.findByUsername(username);
	}

	public void addGameNotification(String courseName, String name) {
		Course c = courseRep.findOne(courseName);
		ArrayList<Student> students = (ArrayList<Student>)c.getStudents();
		for(Student s: students)
		{
			Notification n = new Notification(s.getUsername(), name+" is added to "+courseName+" course.", name);
			notificationRep.save(n);
		}
	}
	
	public void commentNotification(String gameName) {
		Game g = gameRep.findOne(gameName);
		Teacher owner = g.getGameOwner();
		Notification n = new Notification(owner.getUsername(), "New Comment is added to game "+gameName, gameName);
		notificationRep.save(n);
		ArrayList<Teacher> collaborators = (ArrayList<Teacher>) g.getGameCollaborators();
		for(Teacher t: collaborators)
		{
			Notification not = new Notification(t.getUsername(), "New Comment is added to game "+gameName, gameName);
			notificationRep.save(not);
		}
	}
	
}
