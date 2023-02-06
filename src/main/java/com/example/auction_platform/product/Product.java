package com.example.auction_platform.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Product {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private int minPrice;
    @Getter
    @Setter
    private int currentPrice;
    @Getter
    @Setter
    private boolean isActive;

    public Product(String name, String description, int minPrice) {
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.isActive = true;
    }
}
