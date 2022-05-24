package com.projectone.p1.service;

import com.projectone.p1.model.Order;
import com.projectone.p1.model.User;

import java.util.List;

public interface OrderService {
    public boolean addOrders(Order order);
    public boolean deleteOrder(int orderId);
    public boolean updateOrder(Order order);
    public Order getOrderById(int orderId);
    public boolean doesOrderExists(int orderId);
    public List<Order> getOrderByUserId(int userId);

}
