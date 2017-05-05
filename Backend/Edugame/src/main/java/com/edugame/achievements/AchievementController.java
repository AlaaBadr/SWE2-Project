package com.edugame.achievements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edugame.game.Game;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService achievementService;
	
	@CrossOrigin()
	@GetMapping("/edugame/achievements/{username}")
	public List<Achievement> showAchievements(@PathVariable("username") String username)
	{
		List<Achievement> achs = achievementService.showAchievements(username);
		for(Achievement ach: achs)
		{
			Game g = new Game();
			g.setName(ach.getGameinAch().getName());
			ach.setGameinAch(g);
		}
		return achs;
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/{username}/courses/games/{gameName}/levels/{levelno}")
	public void addAchievement(@PathVariable("username") String username,
							   @PathVariable("gameName") String gameName,
							   @PathVariable("levelno") int levelno)
	{
		achievementService.addAchievement(username, gameName, levelno);
	}
	
}
