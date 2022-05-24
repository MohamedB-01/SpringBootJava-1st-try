package com.projectone.p1.service;

import com.projectone.p1.dao.ItemDAO;
import com.projectone.p1.dao.UserDAO;
import com.projectone.p1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemDAO itemDAO;
    @Override
    public boolean addItem(Item item) {
        itemDAO.save(item);
        return true;
    }

    @Override
    public boolean deleteItem(int itemId) {
        itemDAO.deleteById(itemId);
        return true;
    }

    @Override
    public boolean updateItem(Item item) {
        itemDAO.save(item);
        return true;
    }

    @Override
    public Item getItemById(int itemId) {
        Item item = itemDAO.getById(itemId);
        return item;
    }

    @Override
    public boolean doesItemExists(int itemId) {
        return itemDAO.existsById(itemId);
    }

    @Override
    public List<Item> getItembyCartId(int cartId) {
        return itemDAO.findAll(cartId);
    }




    @Override
    public List<Item> getItem(String itemName) {
        return null;
    }

    @Override
    public List<Item> getItem() {
        return null;
    }
}
