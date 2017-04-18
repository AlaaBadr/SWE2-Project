package com.edugame.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private StudentRepository studentRep;
	
	@Autowired
	private TeacherRepository teacherRep;

	public boolean searchUser(String username) {
		if(userRep.findByUsername(username) == null)
			return true;
		return false;
	}
	
	public boolean checkMail(String email) {
		if(userRep.findByEmail(email) == null)
			return true;
		return false;
	}
	
	public User search(String username, String password) {
		return userRep.findByUsernameAndPassword(username, password);
	}
	
	public void addUser(User u) {
		if(u.getIdentity().equals("Teacher"))
			teacherRep.save((Teacher) u);
		else
			studentRep.save((Student) u);
		
	}
	
	public User register(User u)
	{
		if(searchUser(u.getUsername()))
		{
			if(u.getIdentity().equals("Teacher") && !u.getEmail().contains(".edu"))
				return null;
			if(!checkMail(u.getEmail()))
				return null;
			addUser(u);
			return u;
		}
		return null;
	}

}
