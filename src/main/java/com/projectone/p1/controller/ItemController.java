package com.projectone.p1.controller;
import com.projectone.p1.model.Item;
import com.projectone.p1.model.User;
import com.projectone.p1.service.ItemService;
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
@RequestMapping("item")

public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    ItemService itemService;

    // register users
    @PostMapping
    public ResponseEntity<String> saveItem(@RequestBody Item item){
        ResponseEntity responseEntity = null;
        if (itemService.doesItemExists(item.getItemId())) {
            responseEntity = new ResponseEntity<String>
                    ("Item already exists", HttpStatus.CONFLICT);
        }else {
            boolean result = itemService.addItem(item);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully Saved Item " + item.getItemName(), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Cannot save Item", HttpStatus.NOT_ACCEPTABLE);
            }

        }
        return responseEntity;
    }

    @DeleteMapping("{itemId}")
    public ResponseEntity<User> deleteItem(@PathVariable("itemId") int itemId){
        ResponseEntity responseEntity = null;
        if (itemService.doesItemExists(itemId)){
            boolean result = itemService.deleteItem(itemId);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully deleted item " , HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("item was not deleted ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Item does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("{itemId}")
    public ResponseEntity<User> updateUser(@RequestBody Item item){
        ResponseEntity responseEntity = null;
        if (itemService.doesItemExists(item.getItemId())){
            boolean result = itemService.updateItem(item);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully updated item " + item.getItemName(), HttpStatus.OK);        //200
            } else {
                responseEntity = new ResponseEntity<String>
                        ("Item records was not updated ", HttpStatus.EXPECTATION_FAILED);        //406
            }
        }else {
            responseEntity = new ResponseEntity<String>
                    ("Item does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/findItemById/{itemId}")
    public ResponseEntity<User> getUserById(@PathVariable("itemId") int itemId) {
        System.out.println("Fetching details about item by with id  :" + itemId);

        ResponseEntity responseEntity = null;
        Item item = new Item();
        if (itemService.doesItemExists(itemId)) {
            item = itemService.getItemById(itemId);
            responseEntity = new ResponseEntity<Item>(item, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>
                    ("Item does not exist ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/searchCartItems/{cartId}")
    public List<Item> searchCartItems(@PathVariable("cartId") int cartId) {

        List<Item> cartItems = itemService.getItembyCartId(cartId);
        return cartItems;
    }

}
