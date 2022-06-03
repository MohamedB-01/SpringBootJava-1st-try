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
@Table(name = "user", schema = "project")


public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

}
