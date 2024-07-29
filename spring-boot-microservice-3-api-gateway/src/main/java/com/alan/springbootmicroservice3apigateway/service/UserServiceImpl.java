package com.alan.springbootmicroservice3apigateway.service;

import com.alan.springbootmicroservice3apigateway.model.Rol;
import com.alan.springbootmicroservice3apigateway.model.User;
import com.alan.springbootmicroservice3apigateway.repository.UserRepository;
import com.alan.springbootmicroservice3apigateway.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Rol.USER);
        user.setFechaCreacion(LocalDateTime.now());
        user.setToken(jwtProvider.generateToken(user));
        User userCreate = userRepository.save(user);

        return userCreate;

    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional // Para sentencias directas
    @Override
    public void changeRole(Rol newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public User findByUsernameReturnToken(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"+username));
        String jwt = jwtProvider.generateToken(user);
        user.setToken(jwt);
        return user;
    }
}
