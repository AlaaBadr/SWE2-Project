package com.edugame.achievements;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.level.Level;
import com.edugame.level.LevelService;

@Service
public class AchievementService {
	
	@Autowired
	private LevelService levelService;

	HashMap<String, ArrayList<Achievement>> achievements = new HashMap<>();
	
	public AchievementService() throws InterruptedException{
		//levelService = new LevelService();
	}
	
	public Boolean addAchievement(String username, String gameName, int levelno)
	{
		if(!achievements.containsKey(username))
			achievements.put(username, new ArrayList<Achievement>());
		ArrayList<Achievement> userAchievements = achievements.get(username);
		for(Achievement a: userAchievements)
		{
			if(a.getgameName().equals(gameName))
			{
				if(levelno <= a.getScore()/100)
					return false;
				a.setScore(levelno*100);
				return true;
			}
		}
		userAchievements.add(new Achievement(levelno*100, gameName));
		return true;
	}

	public List<Achievement> showAchievements(String username)
	{
		return achievements.get(username);
	}

	public Boolean checkAnswer(String username, String courseName, String gameName, int levelno, int rightAnswer) {
		Level l = levelService.getSpecificLevel(courseName, gameName, levelno);
		if(rightAnswer == l.getRightAnswer())
		{
			addAchievement(username, gameName, levelno);
			return true;
		}
		return false;
	}
}
