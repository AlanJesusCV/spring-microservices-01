package com.alan.springbootmicroservice3apigateway.service;

import com.alan.springbootmicroservice3apigateway.model.Rol;
import com.alan.springbootmicroservice3apigateway.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Rol newRole, String username);

    User findByUsernameReturnToken(String username);
}
