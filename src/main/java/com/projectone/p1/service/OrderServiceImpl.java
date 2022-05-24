package com.projectone.p1.service;

import com.projectone.p1.dao.OrderDAO;
import com.projectone.p1.dao.UserDAO;
import com.projectone.p1.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    OrderDAO orderDAO;
    @Override
    public boolean addOrders(Order order) {
        orderDAO.save(order);
        return true;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        orderDAO.deleteById(orderId);
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        orderDAO.save(order);
        return true;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = orderDAO.getById(orderId);
        return order;
    }

    @Override
    public boolean doesOrderExists(int orderId) {
        return orderDAO.existsById(orderId);
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orderDAO.findByUserId(userId);
    }
}
