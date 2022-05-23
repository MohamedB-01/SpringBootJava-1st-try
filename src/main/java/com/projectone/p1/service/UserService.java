package com.projectone.p1.service;

import com.projectone.p1.model.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(int userId);
    public boolean updateUser(User user);
    public User getUser(int userId);
    public boolean doesUserExists(int userId);
    public List<User> getUser(String username);
    public List<User> getUsers();


}
