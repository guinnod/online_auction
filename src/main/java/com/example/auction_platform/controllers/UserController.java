package com.example.auction_platform.controllers;

import com.example.auction_platform.models.User;
import com.example.auction_platform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping()
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("id")
    public User getUser(@RequestParam(value = "email", defaultValue = "null") String email) {
        return userRepository.findByEmail(email);
    }

    @PostMapping("add")
    public User getUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
