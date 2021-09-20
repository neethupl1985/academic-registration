package com.demo.academicRegistration.service;

import com.demo.academicRegistration.model.User;

public interface UserService {

	/**
	 * Add userdetails for both professor and student.
	 * @param user
	 * @return int
	 */
	int addUser(User user);
}
