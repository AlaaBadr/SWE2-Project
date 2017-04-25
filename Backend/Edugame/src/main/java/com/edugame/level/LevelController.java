package com.edugame.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/games/{gameName}/levels/{levelno}")
	public Level getLevel(@PathVariable("gameName") String gameName, @PathVariable("levelno") int levelno)
	{
		return levelService.getSpecificLevel(gameName, levelno);
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/games/{gameName}/levels")
	public List<Level> getLevels(@PathVariable("gameName") String gameName)
	{
		return levelService.getLevels(gameName);
	}
	
	@CrossOrigin()
	@PostMapping("/edugame/courses/games/{gameName}/levels/addLevel")
	public void addLevel(@PathVariable("gameName") String gameName, @RequestBody Level l)
	{
		levelService.addLevel(l, gameName);
	}
	
	/*
	@CrossOrigin()
	@GetMapping("/edugame/checkAnswer/{username}/{gameName}/{levelno}/{rightAnswer}")
	public Boolean addAchievement(@PathVariable("username") String username,
								  @PathVariable("gameName") String gameName,
								  @PathVariable("levelno") int levelno,
								  @PathVariable("rightAnswer") int rightAnswer)
	{
		return levelService.checkAnswer(username, gameName, levelno, rightAnswer);
	}
	*/
}
