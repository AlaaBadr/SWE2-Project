package com.edugame.achievements;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edugame.game.Game;

public interface AchievementRepository extends CrudRepository<Achievement, AchievementID>{
	List<Achievement> findByStudentUsername(String username);

	void deleteByGameinAch(Game g);
}
