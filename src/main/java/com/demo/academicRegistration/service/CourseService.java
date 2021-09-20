package com.demo.academicRegistration.service;

import com.demo.academicRegistration.model.Course;

public interface CourseService {

    /**
     * Add all the Course Details.
     *
     * @param course
     * @return int
     */
    int addCourse(Course course);

    /**
     * update all the Course Details.
     *
     * @param course
     * @return int
     */
    int updateCourse(Course course);

    /**
     * Delete the Course for a id
     *
     * @param course
     * @return int
     */
    int deleteCourse(int course);

    /**
     * Retreive the Course Details based on course id.
     *
     * @param courseId of the course
     * @return Course
     */
    Course readCourse(int courseId);
}
