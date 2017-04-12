package com.edugame.user;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends UserBaseRepository<User>{

	User findByUsernameAndPassword(String username, String password);
	
}
