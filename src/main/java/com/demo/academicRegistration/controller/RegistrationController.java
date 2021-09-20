package com.demo.academicRegistration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.academicRegistration.model.Registration;
import com.demo.academicRegistration.service.RegistrationService;
import com.demo.academicRegistration.util.Constants;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

	private RegistrationService registrationService;

	@Autowired
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	/**
	 * This method helps to assign course to the user which includes both Student and Professor
	 * @param registration object
	 * @return ResponseEntity with appropriate status code and body
	 */
	@PostMapping
	public ResponseEntity<Object> register(@RequestBody Registration registration) {
		log.debug("Inside register method");
		registrationService.register(registration);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.REGISTRATION_COMPLETED);
	}

}
