package com.thullyoo.login.system.controllers;

import com.thullyoo.login.system.DTOs.LoginRequest;
import com.thullyoo.login.system.DTOs.LoginResponse;
import com.thullyoo.login.system.services.LoginService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialException;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws CredentialException {
        return ResponseEntity.ok(loginService.loginUser(loginRequest));
    }

}
