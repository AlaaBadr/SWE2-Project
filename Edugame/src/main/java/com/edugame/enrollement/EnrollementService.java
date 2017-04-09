package com.edugame.enrollement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edugame.course.Course;
import com.edugame.course.CourseService;

@Service
public class EnrollementService {
	
	private CourseService courseService;

	HashMap<String, ArrayList<Course>> enrolledCourses = new HashMap<>();
	
	public EnrollementService() throws InterruptedException
	{
		courseService  = new CourseService();
		enrolledCourses.put("koko_elda3eef", new ArrayList<Course>());
		enrolledCourses.get("koko_elda3eef").add(courseService.getCourse("Java"));
	}
	
	public List<Course> getStudentCourses(String username)
	{
		return enrolledCourses.get(username);
	}

	public Boolean enroll(String username, String courseName) {
		if(!enrolledCourses.containsKey(username))
			enrolledCourses.put(username, new ArrayList<Course>());
		ArrayList<Course> studentCourses = enrolledCourses.get(username);
		Course c = courseService.getCourse(courseName);
		if(studentCourses.contains(c))
			return false;
		studentCourses.add(c);
		return true;
	}
}
