package com.example.limitedtimedeal.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LimitedTimeDeals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer maxUnits;

    @Column
    private Double dealPrice;

    @Column
    private LocalDateTime dealStart;

    @Column
    private LocalDateTime dealEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(Integer maxUnits) {
        this.maxUnits = maxUnits;
    }

    public Double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public LocalDateTime getDealStart() {
        return dealStart;
    }

    public void setDealStart(LocalDateTime dealStart) {
        this.dealStart = dealStart;
    }

    public LocalDateTime getDealEnd() {
        return dealEnd;
    }

    public void setDealEnd(LocalDateTime dealEnd) {
        this.dealEnd = dealEnd;
    }
}
