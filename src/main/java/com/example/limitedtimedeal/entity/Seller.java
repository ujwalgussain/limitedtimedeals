package com.example.limitedtimedeal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String sellername;

    @OneToMany(mappedBy="seller")
    List<Product> products = new ArrayList<>();
}
