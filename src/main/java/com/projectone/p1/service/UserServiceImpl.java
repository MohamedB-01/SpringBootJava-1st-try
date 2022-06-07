package com.projectone.p1.service;

import com.projectone.p1.dao.UserDAO;
import com.projectone.p1.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    HttpServletRequest req;
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
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
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

    @Override
    public boolean isUsernameExist(String username) {
        if (userDAO.findByUsername(username) == null) return false;
        else return true;
    }

    @Override
    public User login(String username, String password) {
        User user = userDAO.findByUsernameAndPassword(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", user);
        return user;
    }

    @Override
    public void logout() {
        HttpSession session = req.getSession(false);
        if(session == null) return;
        session.invalidate();

    }
}
