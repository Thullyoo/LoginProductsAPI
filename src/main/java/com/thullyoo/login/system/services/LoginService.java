package com.thullyoo.login.system.services;

import com.thullyoo.login.system.DTOs.LoginRequest;
import com.thullyoo.login.system.DTOs.LoginResponse;
import com.thullyoo.login.system.entities.user.User;
import com.thullyoo.login.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialNotFoundException;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginResponse loginUser(LoginRequest loginRequest) throws CredentialException {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());

        if (user.isEmpty()){
            throw new CredentialNotFoundException("Usuário não encontrado");
        }

        if (!passwordEncoder.matches(loginRequest.password(), user.get().getPassword())){
            throw new CredentialException("Usuário ou senha incorretos");
        }

        LoginResponse loginResponse = new LoginResponse(jwtService.createToken(user.get().getEmail(), user.get().getRole()), 360L);

        return loginResponse;



    }

}
