package com.edugame.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseRepository;
import com.edugame.course.CourseService;
import com.edugame.level.Answer;
import com.edugame.level.Level;
import com.edugame.level.LevelRepository;
import com.edugame.user.Teacher;
import com.edugame.user.TeacherRepository;
import com.edugame.user.UserService;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRep;
	
	@Autowired
	private CourseRepository courseRep;
	
	@Autowired
	private TeacherRepository teacherRep;
	
	@Autowired
	private LevelRepository lvlRep;
	
	public GameService() throws InterruptedException{
	}

	public List<Game> getGamesOfCourse(String courseName)
	{
		/*
		Course c = courseService.getCourse(courseName);
		return c.getGames();
		*/
		return gameRep.findByCourseCourseName(courseName);
	}
	
	public Boolean addGame(Game g, String courseName, String username) throws InterruptedException
	{
		/*
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
		games.add(g);
		*/
		if(gameRep.findOne(g.getName()) != null)
			return false;
		Teacher t = teacherRep.findOne(username);
		g.setGameOwner(t);
		Course c = courseRep.findOne(courseName);
		g.setCourse(c);
		ArrayList<Level>levels = (ArrayList<Level>) g.getLevels();
		if(g.getType().equals("TorF"))
		{
			
			for(Level l: levels)
			{
				
				ArrayList<Answer> answers = new ArrayList<>();
				answers.add(new Answer("True"));
				answers.add(new Answer ("False"));
//				for(Answer a : answers)
//				{
//					a.setLevel(l);
//				}
				l.setAnswers(answers);
				
				l.setGame(g);
			}
		}
		gameRep.save(g);
		// Throws an Exception !! Needs to save Answers First
		for(Level l: levels)
		{
			lvlRep.save(l);
		}
		return true;
	}

	public Game getGame(String courseName, String gameName)
	{
		/*
		Course c = courseService.getCourse(courseName);
		List<Game> games = c.getGames();
		for(Game g: games)
		{
			if(g.getName().equals(gameName))
				return g;
		}
		*/
		return gameRep.findByCourseCourseNameAndName(courseName, gameName);
	}

}
