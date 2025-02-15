package com.alan.springbootmicroservice3apigateway.security.jwt;

import com.alan.springbootmicroservice3apigateway.model.User;
import com.alan.springbootmicroservice3apigateway.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest httpServletRequest);

    boolean isTokenValid(HttpServletRequest request);
}
