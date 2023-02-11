package com.example.auction_platform.repositories;

import com.example.auction_platform.models.Bulletin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Abzal Slamkozha
 */

public interface BulletinRepository extends MongoRepository<Bulletin, String> {
    Bulletin findByName(String name);
    @Query("{'isActive' : :#{#isActive}}")
    List<Bulletin> findAllByIsActive(@Param("isActive") boolean isActive);
}
