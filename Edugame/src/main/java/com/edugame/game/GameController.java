package com.edugame.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/showGames/{courseName}")
	public List<Game> getGamesOfCourse(@PathVariable String courseName)
	{
		return gameService.getGamesOfCourse(courseName);
	}
	
	//msh ha5od hna teacherUsername wala 3shan hwa obj gwa elgame nfsaha wala eh?!
	@PostMapping("/addGame/{courseName}/{teacherUsername}")
	public Boolean addGame(@RequestBody Game g, @PathVariable("courseName") String courseName, @PathVariable("teacherUsername") String username) throws InterruptedException
	{
		return gameService.addGame(g, courseName, username);
	}
	
	@RequestMapping("/getGame/{courseName}/{gameName}")
	public Game getGame(@PathVariable("courseName") String courseName, @PathVariable("gameName") String gameName)
	{
		return gameService.getGame(courseName, gameName);
	}
}
