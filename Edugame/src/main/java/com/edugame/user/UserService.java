package com.edugame.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

	public User searchUser(String username) {
		for(User u: users)
		{
			if(u.getUsername().equals(username))
				return u;
		}
		return null;
	}
	
	public boolean checkMail(String email) {
		for(User u: users)
		{
			if(u.getEmail().equals(email))
				return false;
		}
		return true;
	}
	
	public User search(String username, String password) {
		for(User u: users)
		{
			if(u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}
	
	List<User> users = new ArrayList<>(Arrays.asList( new Teacher("Ismail Ahmed", "Male", 21, "ismail@ismail.com", "Ismail_Ahmed", "12345678") ,
			new Student ("Karim", "Male", 20, "koko@elda3eef.com", "koko_elda3eef", "krkr2017")   )    );

	public void addUser(User u) {
		users.add(u);
	}
	
	public User register(@RequestBody User u)
	{
		if(search(u.getUsername(), u.getPassword()) == null)
		{
			if(u.getIdentity().equals("Teacher") && !u.getEmail().contains(".edu"))
				return null;
			if(!checkMail(u.getEmail()))
				return null;
			u.setID();
			addUser(u);
			return u;
		}
		return null;
	}

}
