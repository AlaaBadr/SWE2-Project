package com.edugame.course;

import java.util.List;
import com.edugame.user.Teacher;
import com.edugame.user.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRep;
	
	@Autowired
	private TeacherRepository teacherRep;
	
	public CourseService(){
	}
	
	public List<Course> getAllCourses()
	{
		return (List<Course>) courseRep.findAll();
	}
	
	public List<Course> getAllCoursesByTeacher(String username)
	{
		return courseRep.findAllByCourseOwnerUsername(username);
	}
	
	public Course getCourse(String name)
	{
		return courseRep.findOne(name);
	}
	
	public Course saveCourse(Course c, String username)
	{
		if(courseRep.findOne(c.getName()) != null)
			return null;
		Teacher t = teacherRep.findByUsername(username);
		c.setCourseOwner(t);
		return courseRep.save(c);
	}
}
