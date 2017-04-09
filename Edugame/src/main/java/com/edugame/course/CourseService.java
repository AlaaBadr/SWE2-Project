package com.edugame.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.edugame.user.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.user.UserService;

@Service
public class CourseService {
	
	List<Course> courses;
	public CourseService() throws InterruptedException{
		courses = new ArrayList<>(Arrays.asList(
				new Course ("Java", (Teacher) userService.searchUser("Ismail_Ahmed"), "Java Course for dummies")
				));
	}

	private UserService userService = new UserService();
	
	public List<Course> getAllCourses()
	{
		return courses;
	}
	
	public List<Course> getAllCoursesByTeacher(String username)
	{
		ArrayList<Course> teacherCourses = new ArrayList<>();
		for(Course c: courses)
		{
			if(c.getOwner().getUsername().equals(username))
			{
				teacherCourses.add(c);
			}
		}
		return teacherCourses;
	}
	
	public Course getCourse(String name)
	{
		for(Course c: courses)
		{
			if(c.getName().equals(name))
				return c;
		}
		return null;
	}
	
	public Course saveCourse(Course c) throws InterruptedException
	{
		if(getCourse(c.getName()) == null)
		{
			c.setId();
			courses.add(c);
			return c;
		}
		return null;
	}
}
