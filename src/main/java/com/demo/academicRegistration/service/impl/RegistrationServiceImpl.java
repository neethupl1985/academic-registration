package com.demo.academicRegistration.service.impl;

import com.demo.academicRegistration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.academicRegistration.dao.RegistrationDao;
import com.demo.academicRegistration.model.Registration;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationDao registrationDao;

	@Autowired
	public RegistrationServiceImpl(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	@Override
	public int register(Registration registration) {
		return registrationDao.register(registration);
    }
}
