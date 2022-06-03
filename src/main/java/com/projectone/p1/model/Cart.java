package com.projectone.p1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cart", schema = "project")

//@EntityListeners(AuditingEntityListener.class)

public class Cart {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cartId;
    @ManyToMany
    @JoinColumn(name= "itemId")
    private List<Item> cartItems;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
