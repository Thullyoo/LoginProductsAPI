package com.thullyoo.login.system.DTOs;

public record LoginResponse(String accessToken, Long expiresIn) {
}
