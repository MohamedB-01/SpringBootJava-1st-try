package com.projectone.p1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cart", schema = "project")



public class Cart {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cartId;
    @ManyToMany
    @JoinTable(name = "cartItems",
            joinColumns = @JoinColumn(name = "cartId", referencedColumnName = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "itemId"))
    private List<Item> cartItems;
    @ManyToOne
    @JoinColumn(name= "user_Id")
    private User user;
    private double cartTotal;

}
