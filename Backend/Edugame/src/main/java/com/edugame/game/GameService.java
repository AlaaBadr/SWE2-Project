package com.edugame.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseRepository;
import com.edugame.level.Level;
import com.edugame.notification.NotificationService;
import com.edugame.user.Teacher;
import com.edugame.user.TeacherRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRep;
	
	@Autowired
	private CourseRepository courseRep;
	
	@Autowired
	private TeacherRepository teacherRep;
	
	@Autowired
	private NotificationService notificationService;
		
	public GameService(){
	}

	public List<Game> getGamesOfCourse(String courseName)
	{
		return gameRep.findByCourseCourseName(courseName);
	}
	
	public Boolean addGame(Game g, String courseName, String username)
	{
		if(gameRep.findOne(g.getName()) != null)
			return false;
		Teacher t = teacherRep.findOne(username);
		g.setGameOwner(t);
		Course c = courseRep.findOne(courseName);
		g.setCourse(c);
		gameRep.save(g);
		notificationService.addGameNotification(courseName, g.getName());
		return true;
	}

	public Game getGame(String gameName)
	{
		return gameRep.findOne(gameName);
	}

	public Boolean addCollaborator(String gameName, String username) {
		Teacher t = teacherRep.findByUsername(username);
		Game g = gameRep.findOne(gameName);
		List<Teacher> oldCollaborators = g.getGameCollaborators();
		if(oldCollaborators.contains(t))
			return false;
		oldCollaborators.add(t);
		gameRep.save(g);
		return true;
	}
}
