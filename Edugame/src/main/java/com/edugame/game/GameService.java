package com.edugame.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseService;
import com.edugame.level.Level;
import com.edugame.user.Teacher;
import com.edugame.user.UserService;

@Service
public class GameService {
	
	private CourseService courseService;
	private UserService userService;
	
	public GameService() throws InterruptedException
	{
		courseService = new CourseService();
		userService = new UserService();
	}

	public List<Game> getGamesOfCourse(String courseName) {
		Course c = courseService.getCourse(courseName);
		return c.getGames();
	}
	
	public Boolean addGame(Game g, String courseName) throws InterruptedException
	{
		Course c = courseService.getCourse(courseName);
		if(c == null)
			courseService.saveCourse(c);
		List<Game> games = c.getGames();
		if(games.contains(g))
			return false;
		if(g.getType().equals("TorF"))
		{
			List<Level> levels = g.getLevels();
			for(Level l: levels)
			{
				l.setAnswers("True");
				l.setAnswers("False");
			}
		}
		g.setOwner((Teacher) userService.searchUser(g.getOwner().getUsername()));
		g.setID();
		games.add(g);
		return true;
	}

	public Game getGame(String courseName, String gameName)
	{
		Course c = courseService.getCourse(courseName);
		List<Game> games = c.getGames();
		for(Game g: games)
		{
			if(g.getName().equals(gameName))
				return g;
		}
		return null;
	}

}
