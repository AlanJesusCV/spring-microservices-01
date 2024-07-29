package com.alan.springbootmicroservice3apigateway.service;

import com.alan.springbootmicroservice3apigateway.model.User;

public interface AuthenticationService {
    User singInAndReturnJWT(User signInRequest);
}
