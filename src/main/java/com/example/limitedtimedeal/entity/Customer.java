package com.example.limitedtimedeal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String customerName;

    @OneToMany(mappedBy = "customer")
    List<CustomerOrder> customerOrder = new ArrayList<>();

    //Other details

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CustomerOrder> getOrder() {
        return customerOrder;
    }

    public void setOrder(List<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }
}
