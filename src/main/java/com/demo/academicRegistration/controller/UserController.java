package com.demo.academicRegistration.controller;

import com.demo.academicRegistration.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.academicRegistration.model.User;
import com.demo.academicRegistration.service.UserService;
import com.demo.academicRegistration.util.Constants;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * This method is used to add user which include both Student and Professor
	 * @param user
	 * @return
	 */
	@PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
		log.debug("Inside addUser method");
		if(validateUser(user)) {
			userService.addUser(user);
	        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.USER_CREATED);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).contentType(MediaType.APPLICATION_JSON).body(Constants.INVALID_USER_ROLE);
		}
    }
	
	// Validate that the user is either a Student or a Professor
    private boolean validateUser(User user) {
		boolean isValid = false;
		if(Role.STUDENT.equals(user.getRole()) || Role.PROFESSOR.equals(user.getRole())) {
			isValid = true;
		}
		return isValid;
	}
}
