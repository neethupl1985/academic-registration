package com.demo.academicRegistration.service.impl;

import com.demo.academicRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.academicRegistration.dao.UserDao;
import com.demo.academicRegistration.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
    }
}
