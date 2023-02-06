package com.example.auction_platform.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getAllUsers(){
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
