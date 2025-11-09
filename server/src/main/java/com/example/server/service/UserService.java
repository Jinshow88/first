package com.example.server.service;

import java.util.List;

import com.example.server.entity.Users;
import com.example.server.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getUserApi() {

        return userRepository.findAll();
    }

    public Users userDetail(Integer id) {
        return userRepository.findById(id).get();
    }
    public void createUser(Users user) {
        userRepository.save(user);
    }
    public void userDelete(Integer id) {
        userRepository.deleteById(id);
    }
}
