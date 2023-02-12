package com.example.auction_platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Abzal Slamkozha
 */

@Data
public class Bulletin {
    @MongoId
    private String name;
    private String description;
    private int minPrice;
    private int duration;
    private String author;
    @JsonIgnore
    private byte[] image;
    private int currentPrice;
    private boolean isActive;
    private long endTime;

    public Bulletin(String name, String description, int minPrice,
                    int duration, String author, byte[] image) {
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.duration = duration;
        this.author = author;
        this.image = image;
        this.currentPrice = this.minPrice;
        this.isActive = true;
        this.endTime = System.currentTimeMillis() + ((long) duration * 1000 * 60);
    }
}
