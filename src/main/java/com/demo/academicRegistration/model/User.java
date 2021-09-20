package com.demo.academicRegistration.model;

import com.demo.academicRegistration.enums.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * The User model that stores all the User level data for Student and Professor
 */
@Getter
@Setter
public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private Role role;
}
