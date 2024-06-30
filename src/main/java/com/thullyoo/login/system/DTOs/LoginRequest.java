package com.thullyoo.login.system.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull(message = "Email não pode ser null.") @NotEmpty(message = "Email não pode ser vazio.") @Email(message = "Email inválido.") String email,
                           @NotNull(message = "Senha não pode ser null.") @NotEmpty(message = "Senha não pode ser vazia.") String password) {
}
