package com.Dadhich.Chess.Service;

import com.Dadhich.Chess.Model.User;
import com.Dadhich.Chess.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user); // Automatically handles insert or update
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
