package com.edugame.achievements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService achievementService;
	
	@RequestMapping("/showAchievements/{username}")
	public List<Achievement> showAchievements(@PathVariable("username") String username)
	{
		return achievementService.showAchievements(username);
	}
	
	@RequestMapping("/checkAnswer/{username}/{courseName}/{gameName}/{levelno}/{rightAnswer}")
	public Boolean addAchievement(@PathVariable("username") String username,
								  @PathVariable("courseName") String courseName,
								  @PathVariable("gameName") String gameName,
								  @PathVariable("levelno") int levelno,
								  @PathVariable("rightAnswer") int rightAnswer)
	{
		return achievementService.checkAnswer(username, courseName, gameName, levelno, rightAnswer);
	}
}
