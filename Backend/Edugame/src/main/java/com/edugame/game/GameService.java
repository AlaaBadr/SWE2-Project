package com.edugame.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseRepository;
import com.edugame.level.Level;
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
//		ArrayList<Level>levels = (ArrayList<Level>) g.getLevels();
//		for(Level l: levels)
//		{
//			l.setGame(g);
//		}
		gameRep.save(g);
		return true;
	}

	public Game getGame(String gameName)
	{
		return gameRep.findOne(gameName);
		//return gameRep.findByCourseCourseNameAndName(courseName, gameName);
	}

}
