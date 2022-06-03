package com.projectone.p1.service;

import com.projectone.p1.model.Cart;
import com.projectone.p1.model.Item;
import com.projectone.p1.model.User;

import java.util.List;

public interface ItemService {
    public boolean addItem(Item item);
    public boolean deleteItem(int itemId);
    public boolean updateItem(Item item);
    public Item getItemById(int itemId);
    public boolean doesItemExists(int itemId);
//    public List<Item> getItembyCart(Cart cart);



    List<Item> getItem(String itemName);

    public List<Item> getItem();
}
