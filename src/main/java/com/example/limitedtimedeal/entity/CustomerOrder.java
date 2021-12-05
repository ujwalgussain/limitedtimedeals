package com.example.limitedtimedeal.entity;

import javax.persistence.*;

@Entity
public class CustomerOrder {
    //Assuming that order will have only one item
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity;

}
