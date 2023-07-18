package com.dgmf.dto;

import com.dgmf.entity.user.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;
}
