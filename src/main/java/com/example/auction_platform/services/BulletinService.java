package com.example.auction_platform.services;

import com.example.auction_platform.controllers.BoardController;
import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.models.Sell;
import com.example.auction_platform.models.User;
import com.example.auction_platform.repositories.BulletinRepository;
import com.example.auction_platform.repositories.SellRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Abzal Slamkozha
 */
@Service
@RequiredArgsConstructor
public class BulletinService {
    private final BulletinRepository bulletinRepository;
    private final SellRepository sellRepository;
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    public String add(String name,
                      String description,
                      int minPrice,
                      int duration,
                      MultipartFile file) throws IOException {
        Bulletin bulletin = new Bulletin(name, description, minPrice, duration, file.getBytes());
        bulletinRepository.save(bulletin);
        logger.info("Product: " + bulletin.getName() + " added!");
        return "Successfully added!";
    }

    public String buy(String name, int price) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Bulletin bulletin = bulletinRepository.findByName(name);
        bulletin.setCurrentPrice(bulletin.getCurrentPrice() + price);
        bulletinRepository.save(bulletin);
        sellRepository.save(new Sell(user.getUsername(), name));
        return "Successfully price updated!";
    }
}
