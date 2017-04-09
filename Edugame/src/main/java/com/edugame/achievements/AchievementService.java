package com.edugame.achievements;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.edugame.game.Game;
import com.edugame.game.GameService;

@Service
public class AchievementService {
	
	private GameService gameService;

	HashMap<String, ArrayList<Achievement>> achievements = new HashMap<>();
	
	public AchievementService()
	{
		
	}
	
	public Boolean addAchievement(String username, String courseName, String gameName, int score)
	{
		if(!achievements.containsKey(username))
			achievements.put(username, new ArrayList<Achievement>());
		ArrayList<Achievement> userAchievements = achievements.get(username);
		Game g = gameService.getGame(courseName, gameName);
		for(Achievement a: userAchievements)
		{
			if(a.getGame().equals(g))
			{
				if(a.getScore()==score)
					return false;
				a.setScore(score);
				return true;
			}
		}
		userAchievements.add(new Achievement(score, g));
		return true;
	}

	public List<Achievement> showAchievements(String username)
	{
		return achievements.get(username);
	}
}
