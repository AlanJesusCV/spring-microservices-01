package com.alan.springbootmicroservice3apigateway.controller;

import com.alan.springbootmicroservice3apigateway.model.Rol;
import com.alan.springbootmicroservice3apigateway.security.UserPrincipal;
import com.alan.springbootmicroservice3apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRol(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Rol role){
        userService.changeRole(role, userPrincipal.getUsername());

        return ResponseEntity.ok(true);
    }

    @GetMapping()
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(userService.findByUsernameReturnToken(userPrincipal.getUsername()), HttpStatus.OK);
    }
}
