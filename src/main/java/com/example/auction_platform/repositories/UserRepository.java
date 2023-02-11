package com.example.auction_platform.repositories;

import com.example.auction_platform.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Abzal Slamkozha
 */

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
}
