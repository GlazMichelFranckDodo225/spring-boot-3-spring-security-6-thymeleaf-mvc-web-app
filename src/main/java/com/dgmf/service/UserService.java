package com.dgmf.service;

import com.dgmf.entity.user.User;
import com.dgmf.dto.registration.RegistrationRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest registrationRequest);
    User findByEmail(String email);
}
