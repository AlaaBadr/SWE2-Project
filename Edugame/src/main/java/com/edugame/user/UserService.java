package com.edugame.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		/*for(User u: users)
		{
			if(u.getUsername().equals(username))
				return u;
		}
		return null;
		*/
		if(userRep.findByUsername(username) == null)
			return true;
		return false;
	}
	
	public boolean checkMail(String email) {
		/*for(User u: users)
		{
			if(u.getEmail().equals(email))
				return false;
		}
		return true;
		*/
		if(userRep.findByEmail(email) == null)
			return true;
		return false;
	}
	
	public User search(String username, String password) {
		/*for(User u: users)
		{
			if(u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		}
		return null;
		*/
		return userRep.findByUsernameAndPassword(username, password);
	}
	
//	List<User> users = new ArrayList<>(Arrays.asList( new Teacher("Ismail Ahmed", "Male", 21, "ismail@ismail.com", "Ismail_Ahmed", "12345678") ,
//			new Student ("Karim", "Male", 20, "koko@elda3eef.com", "koko_elda3eef", "krkr2017")   )    );

	public void addUser(User u) {
		//users.add(u);
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
