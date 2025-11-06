package com.example.server.controller;

import java.util.List;

import com.example.server.entity.Users;
import com.example.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/user")
    public List<Users> userApi() {

        return userService.getUserApi();
    }
}