package com.example.auction_platform.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class User {
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
}
