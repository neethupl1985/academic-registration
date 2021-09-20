package com.demo.academicRegistration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.academicRegistration.model.Course;
import com.demo.academicRegistration.service.CourseService;
import com.demo.academicRegistration.util.Constants;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * This method is to add a course.
     *
     * @param course object to add
     * @return ResponseEntity with appropriate status code and body
     */
    @PostMapping
    public ResponseEntity<Object> addCourse(@RequestBody Course course) {
        log.debug("Inside addCourse method");
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.COURSE_CREATED);
    }

    /**
     * This method is to update course details
     *
     * @param course object to add
     * @return ResponseEntity with appropriate status code and body
     */
    @PutMapping(path = "/updateCourse")
    public ResponseEntity<Object> updateCourse(@RequestBody Course course) {
        log.debug("Inside updateCourse method");
        courseService.updateCourse(course);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.COURSE_UPDATED);
    }

    /**
     * This method is to delete a course for a id.
     *
     * @param courseId object to add
     * @return ResponseEntity with appropriate status code and body
     */
    @DeleteMapping(path = "/delete/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable int courseId) {
        log.debug("Inside deleteCourse method");
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.COURSE_DELETED);
    }

    /**
     * This method is to retrieve the course details for a course.
     *
     * @param courseId id of the course
     * @return ResponseEntity with appropriate status code and Course Object
     */
    @GetMapping(path = "/read/{courseId}")
    public ResponseEntity<Object> readCourse(@PathVariable int courseId) {
        log.debug("Inside readCourse method");
        courseService.readCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON).body(courseService.readCourse(courseId));
    }
}
