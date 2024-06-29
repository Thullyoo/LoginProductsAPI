package com.thullyoo.login.system.services;

import com.nimbusds.jwt.JWT;
import com.thullyoo.login.system.entities.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JWTService {

    @Autowired
    private JwtEncoder jwtEncoder;

    public String createToken(String email, Role role) {

        var claims = JwtClaimsSet.builder()
                .issuer("JWTService")
                .subject(email)
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(360L))
                .claim("scope", role.name())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
