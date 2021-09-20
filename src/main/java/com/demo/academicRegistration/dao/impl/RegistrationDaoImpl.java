package com.demo.academicRegistration.dao.impl;

import com.demo.academicRegistration.dao.RegistrationDao;
import com.demo.academicRegistration.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegistrationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int register(Registration registration) {
        return jdbcTemplate.update("INSERT INTO registration (user_id, course_id) VALUES (?, ?)",
                new Object[] {registration.getUserId(), registration.getCourseId()});
    }
}



