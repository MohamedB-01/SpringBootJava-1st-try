package com.projectone.p1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name= "item", schema = "project")




public class Item {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private double price;
//    @ManyToMany
//    @JoinColumn(name = "cartId")
//    private Cart cart;


}
