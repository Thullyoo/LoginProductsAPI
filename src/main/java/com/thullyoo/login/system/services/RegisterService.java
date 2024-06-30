package com.thullyoo.login.system.services;

import com.thullyoo.login.system.DTOs.RegisterRequest;
import com.thullyoo.login.system.DTOs.RegisterResponse;
import com.thullyoo.login.system.entities.role.Role;
import com.thullyoo.login.system.entities.user.User;
import com.thullyoo.login.system.exceptions.UserIsPresentException;
import com.thullyoo.login.system.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RegisterService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public RegisterService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public RegisterResponse registerUser(RegisterRequest registerRequest){
        Optional<User> userOptional = userRepository.findByEmail(registerRequest.email());

        if (userOptional.isPresent()){
            throw new UserIsPresentException("Usuário já registrado");
        }

        User user = new User();

        user.setName(registerRequest.name());
        user.setRole(Role.COMMON);
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setOrders(Set.of());
        user.setEmail(registerRequest.email());

        userRepository.save(user);

        return new RegisterResponse(jwtService.createToken(user.getEmail(), user.getRole()), 320L);


    }
}
