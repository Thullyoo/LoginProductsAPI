package com.thullyoo.login.system.controllers;

import com.thullyoo.login.system.DTOs.LoginRequest;
import com.thullyoo.login.system.DTOs.LoginResponse;
import com.thullyoo.login.system.services.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialException;

@RestController
@RequestMapping(produces = {"application/json"})
@Tag(name = "login-api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "Faz o login do usuário.",  method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso!"),
            @ApiResponse(responseCode = "422", description = "Erro ao tentar logar usuário")
    })
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) throws CredentialException {
        return ResponseEntity.ok(loginService.loginUser(loginRequest));
    }

}
