package com.example.auction_platform.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Abzal Slamkozha
 */

@Data
@AllArgsConstructor
public class Sell {
    private String email;
    private String productName;
}
