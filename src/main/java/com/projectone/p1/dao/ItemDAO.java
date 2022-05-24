package com.projectone.p1.dao;

import com.projectone.p1.model.Item;
import com.projectone.p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemDAO extends JpaRepository<Item, Integer> {
//    @Query("SELECT i FROM Item i WHERE i.cartId = ?1")
    List <Item> findByCartId(int cartId);
}
