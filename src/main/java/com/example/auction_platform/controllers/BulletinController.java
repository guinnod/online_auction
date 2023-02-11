package com.example.auction_platform.controllers;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Abzal Slamkozha
 */

@RestController
@RequestMapping(path = "home")
@RequiredArgsConstructor
public class BulletinController {
    private final BulletinRepository bulletinRepository;
    private final SellRepository sellRepository;
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);
    @PostMapping("add")
    public String add(@RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("minPrice") int minPrice,
                           @RequestParam("image") MultipartFile file) throws IOException {
        Bulletin bulletin = new Bulletin(name, description, minPrice, file.getBytes());
        bulletinRepository.save(bulletin);
        logger.info("Product: " + bulletin + "added!");
        return "Successfully added!";
    }

    @PostMapping("buy")
    public String buy(@RequestParam("name") String name, @RequestParam("price") int price) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Bulletin bulletin = bulletinRepository.findByName(name);
        bulletin.setCurrentPrice(bulletin.getCurrentPrice() + price);
        bulletinRepository.save(bulletin);
        sellRepository.save(new Sell(user.getUsername(), name));
        return "Successfully price updated!";
    }

}
