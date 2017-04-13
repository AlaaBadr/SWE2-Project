package com.edugame.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.edugame.user.Teacher;
import com.edugame.user.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.user.UserService;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRep;
	
	@Autowired
	private TeacherRepository teacherRep;
	
	List<Course> courses;
	public CourseService() throws InterruptedException{
		userService = new UserService();
		courses = new ArrayList<>(Arrays.asList(
				//new Course ("Java", (Teacher) userService.searchUser("Ismail_Ahmed"), "Java Course for dummies")
				));
	}

	private UserService userService;
	
	public List<Course> getAllCourses()
	{
		//return courses;
		return (List<Course>) courseRep.findAll();
	}
	
	public List<Course> getAllCoursesByTeacher(String username)
	{
		/*
		ArrayList<Course> teacherCourses = new ArrayList<>();
		for(Course c: courses)
		{
			if(c.getOwner().getUsername().equals(username))
			{
				teacherCourses.add(c);
			}
		}
		return teacherCourses;
		*/
		return courseRep.findAllByCourseOwnerUsername(username);
	}
	
	public Course getCourse(String name)
	{
		/*for(Course c: courses)
		{
			if(c.getName().equals(name))
				return c;
		}
		return null;
		*/
		return courseRep.findOne(name);
	}
	
	public Course saveCourse(Course c, String username) throws InterruptedException
	{
		/*if(getCourse(c.getName()) == null)
		{
			courses.add(c);
			return c;
		}
		return null;
		*/
		if(courseRep.findOne(c.getName()) != null)
			return null;
		Teacher t = teacherRep.findByUsername(username);
		c.setCourseOwner(t);
		return courseRep.save(c);
	}
}
