package com.projectone.p1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table

public class User {
    @Id

    private int userId;
    private String username;
    private String password;
//    @OneToMany(cascade = CascadeType.ALL, targetEntity = Order.class)
//    @JoinColumn(name = "from_user_id")
//    private List<Order> orderList;
//
//    @OneToOne(cascade = CascadeType.ALL, targetEntity = Cart.class)
//    @JoinColumn(name = "from_user_id")
//    private List<Order> cartList;

}
