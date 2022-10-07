package com.vallerry.opcd.web.controller;

import com.vallerry.opcd.data.AdminRepository;
import com.vallerry.opcd.model.User;
import com.vallerry.opcd.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private AdminRepository adminRepository;

    public UserController(UserService userService, AdminRepository adminRepository) {
        this.userService = userService;
        this.adminRepository = adminRepository;
    }

    @ResponseBody
    @GetMapping("/get_user")
    public Optional<User> getUser(String email, String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @ResponseBody
    @PostMapping("/registration")
    public void registerUser(@RequestBody User user) {
        userService.registration(user);
//        return user;
    }
}
