package com.projectone.p1.controller;
import com.projectone.p1.model.Cart;
import com.projectone.p1.model.Order;
import com.projectone.p1.service.CartService;
import com.projectone.p1.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;


    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        ResponseEntity responseEntity = null;
        if (orderService.doesOrderExists(order.getOrderId())) {
            responseEntity = new ResponseEntity<String>
                    ("order already exists", HttpStatus.CONFLICT);
        }else {
            boolean result = orderService.addOrders(order);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully Saved order " , HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Cannot save order", HttpStatus.NOT_ACCEPTABLE);
            }

        }
        return responseEntity;
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<Cart> deleteOrder(@PathVariable("orderId") int orderId){
        ResponseEntity responseEntity = null;
        if (orderService.doesOrderExists(orderId)){
            boolean result = orderService.deleteOrder(orderId);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully deleted Order " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("order was not deleted ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Order does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("{orderId}")
    public ResponseEntity<Cart> updateCart(@RequestBody Order order){
        ResponseEntity responseEntity = null;
        if (orderService.doesOrderExists(order.getOrderId())){
            boolean result = orderService.updateOrder(order);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully updated Order " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Order record was not updated ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        }else {
            responseEntity = new ResponseEntity<String>
                    ("Order does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/findOrderById/{orderId}")
    public ResponseEntity<Cart> getOrderById(@PathVariable("orderId") int orderId) {
        System.out.println("Fetching details about cart with id  :" + orderId);

        ResponseEntity responseEntity = null;
        Order order = new Order();
        if (orderService.doesOrderExists(orderId)) {
            order = orderService.getOrderById(orderId);
            responseEntity = new ResponseEntity<Order>(order, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Order does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/findOrderByUserId/{userId}")
    public ResponseEntity<Order> getOrderByUserId(@PathVariable("userId") int userId) {
        System.out.println("Fetching details about Order with userId  :" + userId);

        ResponseEntity responseEntity = null;
        List <Order> userOrders ;
        if (orderService.doesUserIdExists(userId)) {
            userOrders = orderService.getOrderByUserId(userId);
            responseEntity = new ResponseEntity<List>(userOrders, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>
                    ("User Id does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}
