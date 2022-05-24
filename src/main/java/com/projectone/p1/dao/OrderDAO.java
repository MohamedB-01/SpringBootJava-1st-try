package com.projectone.p1.dao;

import com.projectone.p1.model.Cart;
import com.projectone.p1.model.Order;
import com.projectone.p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    List<Order> findAll(int userId);
}
