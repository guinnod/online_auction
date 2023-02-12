package com.example.auction_platform.controllers;

import com.example.auction_platform.services.BulletinService;

import lombok.RequiredArgsConstructor;

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
    private final BulletinService bulletinService;

    @PostMapping("add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("description") String description,
                      @RequestParam("minPrice") int minPrice,
                      @RequestParam("duration") int duration,
                      @RequestParam("image") MultipartFile file) throws IOException {
        return bulletinService.add(name, description, minPrice, duration, file);
    }

    @PostMapping("buy")
    public String buy(@RequestParam("name") String name, @RequestParam("price") int price) {
        return bulletinService.buy(name, price);
    }
}
