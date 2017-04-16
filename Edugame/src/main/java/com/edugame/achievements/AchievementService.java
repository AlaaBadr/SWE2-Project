package com.edugame.achievements;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.GameRepository;
import com.edugame.level.Level;
import com.edugame.level.LevelService;
import com.edugame.user.StudentRepository;

@Service
public class AchievementService {
	
	@Autowired
	private LevelService levelService;
	
	@Autowired
	private AchievementRepository achRep;
	
	@Autowired
	private StudentRepository studentRep;
	
	@Autowired
	private GameRepository gameRep;

	HashMap<String, ArrayList<Achievement>> achievements = new HashMap<>();
	
	public AchievementService() throws InterruptedException{
		//levelService = new LevelService();
	}
	
	public void addAchievement(String username, String gameName, int levelno)
	{
		/*
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
		*/
		AchievementID achId = new AchievementID(username, gameName);
		if(levelno*100 <= achRep.findOne(achId).getScore())
			return;
		Achievement ach = new Achievement(levelno*100, studentRep.findByUsername(username), gameRep.findOne(gameName));
		achRep.save(ach);
	}

	public List<Achievement> showAchievements(String username)
	{
		return (List<Achievement>) achRep.findAll();
		//return achievements.get(username);
	}

}
