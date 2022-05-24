package com.projectone.p1.dao;

import com.projectone.p1.model.Cart;
import com.projectone.p1.model.Order;
import com.projectone.p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
//    @Query("SELECT o FROM Order o WHERE 0.userId = ?1")
    List<Order> findByUserId(int userId);
}
