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
	
	@PostMapping("/addAchievement")
	public Boolean addAchievement(@RequestParam("username") String username,
								  @RequestParam("courseName") String courseName,
								  @RequestParam("gameName") String gameName,
								  @RequestParam("score") int score)
	{
		return achievementService.addAchievement(username, courseName, gameName, score);
	}
}
