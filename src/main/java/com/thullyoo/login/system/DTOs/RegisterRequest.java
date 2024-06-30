package com.thullyoo.login.system.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(@NotNull(message = "Nome não pode ser null.") @NotEmpty(message = "Nome não pode ser vazio") String name,
                              @NotNull(message = "Senha não pode ser null.") @NotEmpty(message = "Senha não pode ser vazia") String password,
                              @NotNull(message = "Email não pode ser null.") @NotEmpty(message = "Email não pode ser vazio.") @Email(message = "Email inválido.") String email) {
}
