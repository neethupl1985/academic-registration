package com.demo.academicRegistration.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The course model which houses the course attributes
 */
@Getter
@Setter
public class Course {
	private int id;
	private String courseName;
    private Integer courseYear;
}
