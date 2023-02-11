package com.example.auction_platform.controllers;

import com.example.auction_platform.models.User;
import com.example.auction_platform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abzal Slamkozha
 */

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("add")
    public User getUser(@RequestBody User user) {
        logger.info("User: " + user + " saved!");
        return userRepository.save(user);
    }
}
