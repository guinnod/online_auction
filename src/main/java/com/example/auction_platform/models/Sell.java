package com.example.auction_platform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Abzal Slamkozha
 */

@Data
@AllArgsConstructor
public class Sell {
    @MongoId
    private String email;
    private String productName;
}
