package com.edugame.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.achievements.Achievement;
import com.edugame.achievements.AchievementRepository;
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
	
	@Autowired
	private AchievementRepository achRep;
		
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

	public void copyGame(String gameName, String courseName) {
		Game oldg = gameRep.findOne(gameName);
		Game g = new Game();
		Course c = courseRep.findOne(courseName);
		Teacher t = c.getCourseOwner();
		g.setName(gameName+"-Copy-"+c.getCourseOwner().getUsername());
		g.setGameOwner(t);
		g.setDescription(oldg.getDescription());
		g.setCourse(c);
		g.setLevelno(oldg.getLevelno());
		g.setType(oldg.getType());
		List<Level> levels = oldg.getLevels();
		g.setLevels(new ArrayList<Level>());
		for(Level l: levels)
		{
			Level newl = new Level();
			newl.setLevelName(l.getLevelName()+"-Copy-"+c.getCourseOwner().getUsername());
			newl.setAnswers(l.getAnswers());
			newl.setGame(g);
			newl.setNumber(l.getNumber());
			newl.setQuestion(l.getQuestion());
			newl.setRightAnswer(l.getRightAnswer());
			g.getLevels().add(newl);
		}
		gameRep.save(g);
	}
	
	public void deleteGame(String gameName) {
		Game g = gameRep.findOne(gameName);
		List<Achievement> achs = (List<Achievement>) achRep.findAll();
		for(Achievement ach: achs)
		{
			if(g.equals(ach.getGameinAch()))
					achRep.delete(ach);
		}
		List<Teacher> collaborators = g.getGameCollaborators();
		collaborators.clear();
		gameRep.save(g);
		gameRep.delete(gameName);
	}
}
