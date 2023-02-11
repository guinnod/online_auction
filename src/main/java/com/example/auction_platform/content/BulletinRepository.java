package com.example.auction_platform.content;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BulletinRepository extends MongoRepository<Bulletin, String> {
    public Bulletin findByName(String name);
}
