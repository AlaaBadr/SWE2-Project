package com.edugame.achievements;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AchievementRepository extends CrudRepository<Achievement, AchievementID>{
	List<Achievement> findByStudentUsername(String username);
}
