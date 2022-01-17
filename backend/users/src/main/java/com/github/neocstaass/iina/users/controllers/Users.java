package com.github.neocstaass.iina.users.controllers;

import com.github.neocstaass.iina.users.models.User;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/")
public class Users {

    @GetMapping("user-info")
    public User getUserInfo(@RequestParam(name = "id") String userID) {
        User user = new User();
        user.setUserID(userID);
        user.setUserName("Nope");
        return user;
    }
}
