package com.github.neocstaass.iina.users.controllers;

import com.github.neocstaass.iina.users.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/groups")
public class Groups {

    @GetMapping("group-members")
    public List<User> getGroupMembers(@RequestParam(name = "id") String groupID) {
        List<User> members = new ArrayList<>();
        members.add(new User());
        return members;
    }
}
