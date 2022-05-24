package com.projectone.p1.controller;

import com.projectone.p1.model.User;
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
@RequestMapping("user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    // register users
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        ResponseEntity responseEntity = null;
        if (userService.isUserExists(user.getUserId())) {
            responseEntity = new ResponseEntity<String>
                    ("user already exists", HttpStatus.CONFLICT);   //409
        }else {
            boolean result = userService.addUser(user);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully Saved User " + user.getUsername(), HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Cannot save User", HttpStatus.NOT_ACCEPTABLE);        //406
            }

        }
        return responseEntity;
    }

    //deleting users
    @DeleteMapping("{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId){
        ResponseEntity responseEntity = null;
        if (userService.isUserExists(userId)){
            boolean result = userService.deleteUser(userId);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully deleted user " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("user was not deleted ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        } else {
            responseEntity = new ResponseEntity<String>
                    ("User does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    // updating user
    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        ResponseEntity responseEntity = null;
        if (userService.isUserExists(user.getUserId())){
            boolean result = userService.updateUser(user);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully updated user " + user.getUsername(), HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("User records was not updated ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        }else {
            responseEntity = new ResponseEntity<String>
                    ("User does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }



}
