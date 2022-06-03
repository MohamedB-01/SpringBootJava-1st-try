package com.projectone.p1.controller;
import com.projectone.p1.model.Cart;
import com.projectone.p1.model.User;
import com.projectone.p1.service.CartService;
import com.projectone.p1.service.UserService;
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
@RequestMapping("cart")

public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    // register users
    @PostMapping
    public ResponseEntity<String> saveCart(@RequestBody Cart cart){
        ResponseEntity responseEntity = null;
        if (cartService.doesCartExists(cart.getCartId())) {
            responseEntity = new ResponseEntity<String>
                    ("cart already exists", HttpStatus.CONFLICT);
        }else {
            boolean result = cartService.addCart(cart);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully Saved cart " , HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Cannot save cart", HttpStatus.NOT_ACCEPTABLE);
            }

        }
        return responseEntity;
    }

    @DeleteMapping("{cartId}")
    public ResponseEntity<Cart> deleteCart(@PathVariable("cartId") int cartId){
        ResponseEntity responseEntity = null;
        if (cartService.doesCartExists(cartId)){
            boolean result = cartService.deletCart(cartId);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully deleted cart " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("cart was not deleted ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Cart does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("{cartId}")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
        ResponseEntity responseEntity = null;
        if (cartService.doesCartExists(cart.getCartId())){
            boolean result = cartService.updateCart(cart);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully updated Cart " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Cart records was not updated ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        }else {
            responseEntity = new ResponseEntity<String>
                    ("Cart does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/findCartById/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId") int cartId) {
        System.out.println("Fetching details about cart with id  :" + cartId);

        ResponseEntity responseEntity = null;
        Cart cart = new Cart();
        if (cartService.doesCartExists(cartId)) {
            cart = cartService.getCart(cartId);
            responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Cart does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

//    @GetMapping("/findCartByUserId/{userId}")
//    public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId") int userId) {
//        System.out.println("Fetching details about cart with userId  :" + userId);
//
//        ResponseEntity responseEntity = null;
//        Cart cart = new Cart();
//        if (cartService.doesUserIdExists(userId)) {
//            cart = cartService.getCartbyUserId(userId);
//            responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.OK);
//        } else {
//            responseEntity = new ResponseEntity<String>
//                    ("User Id does not exist ", HttpStatus.NOT_FOUND);
//        }
//        return responseEntity;
//    }




}
