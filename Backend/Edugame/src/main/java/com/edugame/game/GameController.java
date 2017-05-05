package com.edugame.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edugame.user.Teacher;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/{courseName}/games")
	public List<Game> getGamesOfCourse(@PathVariable("courseName") String courseName)
	{
		List<Game> result = gameService.getGamesOfCourse(courseName);
		for(Game g: result)
		{
			Teacher t = new Teacher();
			t.setUsername(g.getGameOwner().getUsername());
			g.setGameOwner(t);
			g.setGameCollaborators(null);
			g.getCourse().setCourseOwner(t);
			g.getCourse().setStudents(null);
		}
		return result;
	}
	
	@CrossOrigin()
	@PostMapping("/edugame/courses/{teacherUsername}/{courseName}/games/addGame")
	public Boolean addGame(@RequestBody Game g, @PathVariable("courseName") String courseName, @PathVariable("teacherUsername") String username) throws InterruptedException
	{
		return gameService.addGame(g, courseName, username);
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/games/{gameName}")
	public Game getGame(@PathVariable("gameName") String gameName)
	{
		Game g = gameService.getGame(gameName);
		Teacher t = new Teacher();
		t.setUsername(g.getGameOwner().getUsername());
		g.setGameOwner(t);
		g.setGameCollaborators(null);
		g.getCourse().setCourseOwner(t);
		g.getCourse().setStudents(null);
		return g;
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/games/{gameName}/addCollaborator/{username}")
	public Boolean addCollaborator(@PathVariable("gameName") String gameName, @PathVariable("username") String username)
	{
		return gameService.addCollaborator(gameName, username);
	}
}
