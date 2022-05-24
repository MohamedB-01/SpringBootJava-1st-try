package com.projectone.p1.service;

import com.projectone.p1.dao.UserDAO;
import com.projectone.p1.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;
    @Override
    public boolean addUser(User user) {
        userDAO.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(int userId) {
        userDAO.deleteById(userId);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userDAO.save(user);
        return true;
    }

    @Override
    public int getUserId(int userId) {
        userDAO.findById(userId);
        return userId;
    }

    @Override
    public User getUserById(int userId) {
        User user = userDAO.getById(userId);
        return user;
    }


    @Override
    public boolean isUserExists(int userId) {
        return userDAO.existsById(userId);
    }

    @Override
    public List<User> getUser(String username) {
        return userDAO.findAll(username);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public boolean isUsernameAndPasswordCorrect(String username, String password) {
        if (userDAO.findByUsernameAndPassword(username, password ) == null) return false;
        else return true;
    }
}
