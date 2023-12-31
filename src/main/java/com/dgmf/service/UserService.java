package com.dgmf.service;

import com.dgmf.entity.user.User;
import com.dgmf.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerUser(UserDTO userDTO);
    User findByEmail(String email);
    User getById(Long id);
    void deleteById(Long id);
}
