package com.edugame.achievements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.GameRepository;
import com.edugame.user.StudentRepository;

@Service
public class AchievementService {
		
	@Autowired
	private AchievementRepository achRep;
	
	@Autowired
	private StudentRepository studentRep;
	
	@Autowired
	private GameRepository gameRep;
	
	public AchievementService() throws InterruptedException{
	}
	
	public void addAchievement(String username, String gameName, int levelno)
	{
		AchievementID achId = new AchievementID(username, gameName);
		if(levelno*100 <= achRep.findOne(achId).getScore())
			return;
		Achievement ach = new Achievement(levelno*100, studentRep.findByUsername(username), gameRep.findOne(gameName));
		achRep.save(ach);
	}

	public List<Achievement> showAchievements(String username)
	{
		return (List<Achievement>) achRep.findAll();
	}

}
