package com.demo.academicRegistration.service;

import com.demo.academicRegistration.model.Registration;

public interface RegistrationService {

	/**
	 * Register Professors and Students to different courses.
	 * @param registration
	 * @return int
	 */
	int register(Registration registration);
}
