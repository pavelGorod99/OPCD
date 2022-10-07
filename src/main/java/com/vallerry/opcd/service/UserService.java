package com.vallerry.opcd.service;

import com.vallerry.opcd.data.UserRepository;
import com.vallerry.opcd.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registration(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(userRepository.getUserByEmailAndPassword(email, password));
    }
}
