package com.dgmf.service.impl;

import com.dgmf.entity.user.Role;
import com.dgmf.entity.user.User;
import com.dgmf.dto.UserDTO;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        var user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));

        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );
    }
}
