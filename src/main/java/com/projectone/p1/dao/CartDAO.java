package com.projectone.p1.dao;

import com.projectone.p1.model.Cart;

import com.projectone.p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);
}
