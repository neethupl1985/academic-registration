package com.demo.academicRegistration.service;


import com.demo.academicRegistration.dao.impl.CourseDaoImpl;
import org.junit.Test;import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.academicRegistration.model.Course;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCourseService {

	@Autowired
	private CourseService courseService;

	@MockBean
	private CourseDaoImpl courseDao;
	

	@Test
	public void testAddCourse() {
		when(courseDao.addCourse(buildCourse())).thenReturn(0);
		assertEquals(0, courseService.addCourse(buildCourse()));
	}

	private Course buildCourse() {
		Course course = new Course();
		course.setCourseName("HISTORY");
		course.setCourseYear(1);
		return course;
	}
}
