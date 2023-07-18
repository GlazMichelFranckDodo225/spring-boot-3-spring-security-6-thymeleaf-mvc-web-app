package com.dgmf.service;

import com.dgmf.entity.user.User;
import com.dgmf.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerUser(UserDTO registrationRequest);
    User findByEmail(String email);
}
