package com.thullyoo.login.system.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(@NotNull(message = "E-mail não pode ser null") @NotBlank(message = "E-mail não pode ser em branco") String emailUser,
                           @NotEmpty(message = "Lista de produtos não pode ser vazia") List<Long> productsId) {
}
