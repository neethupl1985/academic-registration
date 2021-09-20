package com.demo.academicRegistration.dao;

import com.demo.academicRegistration.model.Registration;


public interface RegistrationDao {
	/**
	 * Register the course for both Students and Professors
	 * @param registration
	 * @return int
	 */
	int register(Registration registration);
}
