package com.edugame.achievements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService achievementService;
	
	@GetMapping("/edugame/achievements/{username}")
	public List<Achievement> showAchievements(@PathVariable("username") String username)
	{
		return achievementService.showAchievements(username);
	}
	
}
