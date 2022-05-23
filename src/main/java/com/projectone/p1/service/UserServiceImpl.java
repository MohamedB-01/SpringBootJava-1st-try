package com.projectone.p1.service;

import com.projectone.p1.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public boolean doesUserExists(int userId) {
        return false;
    }

    @Override
    public List<User> getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
