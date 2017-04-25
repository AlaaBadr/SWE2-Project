package com.edugame.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String>{

	T findByUsername(String username);

	T findByEmail(String email);

}
