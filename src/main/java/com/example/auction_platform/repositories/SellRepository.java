package com.example.auction_platform.repositories;

import com.example.auction_platform.models.Sell;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Abzal Slamkozha
 */

public interface SellRepository extends MongoRepository<Sell, String> {
    public Sell findByProductName(String productName);
}
