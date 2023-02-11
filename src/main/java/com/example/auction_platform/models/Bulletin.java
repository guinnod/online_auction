package com.example.auction_platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Abzal Slamkozha
 */

@Data
public class Bulletin {
    @MongoId
    private String name;
    private String description;
    private int minPrice;
    @JsonIgnore
    private byte[] image;
    private int currentPrice;
    private boolean isActive;
    private long endTime;

    public Bulletin(String name, String description, int minPrice, byte[] image) {
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.image = image;
        this.currentPrice = this.minPrice;
        this.isActive = true;
        this.endTime = System.currentTimeMillis() + 12000;
    }
}
