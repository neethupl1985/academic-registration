package com.demo.academicRegistration.dao.impl;

import com.demo.academicRegistration.dao.CourseDao;
import com.demo.academicRegistration.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addCourse(Course course) {
        return jdbcTemplate.update("INSERT INTO course (course_name, course_year) VALUES (?, ?)",
                new Object[]{course.getCourseName(), course.getCourseYear()});
    }

    @Override
    public Course readCourse(int courseId) {
        return jdbcTemplate.queryForObject("SELECT course_name, course_year from course where course_id = ?",
                Course.class, new Object[] {courseId});
    }

    @Override
    public int deleteCourse(int courseId) {
        return jdbcTemplate.update("DELETE FROM course where course_id = ?", new Object[] {courseId});
    }

    @Override
    public int updateCourse(Course course) {
        Course currentCourse = readCourse(course.getId());
        if (course.getCourseYear() == null) {
            course.setCourseYear(currentCourse.getCourseYear());
        }
        if (course.getCourseName() == null) {
            course.setCourseName(currentCourse.getCourseName());
        }
        return jdbcTemplate.update("UPDATE COURSE SET course_name = ?, course_year=? WHERE course_id = ?",
                new Object[] {course.getCourseName(), course.getCourseYear(), course.getId()});
    }
}
