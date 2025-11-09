package com.example.server.controller;

import java.util.List;

import com.example.server.entity.Users;
import com.example.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/user/create")
    public String createUserPro(Users user) {
        userService.createUser(user);

        return "redirect:http://localhost:3000/";
    }

    @GetMapping("/user/delete")
    public String userDeletePro(Integer id) {
        userService.userDelete(id);

        return "redirect:http://localhost:3000/";
    }

    @PostMapping("/user/update")
    public String userUpdatePro(Integer id, Users user) {
        Users userTemp = userService.userDetail(id);
        userTemp.setIntroduce(user.getIntroduce());

        userService.createUser(userTemp);
        return "redirect:http://localhost:3000/";
    }
}