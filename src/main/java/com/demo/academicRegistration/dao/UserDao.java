package com.demo.academicRegistration.dao;

import com.demo.academicRegistration.model.User;

public interface UserDao {

	/**
	 * Register both students and professors
	 * @param user
	 * @return int
	 */
	int addUser(User user);
}
