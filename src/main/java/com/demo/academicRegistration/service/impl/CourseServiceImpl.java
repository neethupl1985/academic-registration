package com.demo.academicRegistration.service.impl;

import com.demo.academicRegistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.academicRegistration.dao.CourseDao;
import com.demo.academicRegistration.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public int addCourse(Course course) {
		return courseDao.addCourse(course);
    }

	@Override
	public int updateCourse(Course course) {
		return courseDao.updateCourse(course);
	}

	@Override
	public int deleteCourse(int courseId) {
		return courseDao.deleteCourse(courseId);
	}

	@Override
	public Course readCourse(int courseId) {
		return courseDao.readCourse(courseId);
	}
}
