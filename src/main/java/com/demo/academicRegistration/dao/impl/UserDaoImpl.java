package com.demo.academicRegistration.dao.impl;

import com.demo.academicRegistration.dao.UserDao;
import com.demo.academicRegistration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO user (first_name, last_name, role) VALUES (?, ?, ?)",
                new Object[] {user.getFirstName(), user.getLastName(), user.getRole()});
    }
}
