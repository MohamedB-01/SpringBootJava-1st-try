package com.projectone.p1.dao;

import com.projectone.p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
public User findByUsernameAndPassword(String username, String password);

    List<User> findByUsername(String username);




}
