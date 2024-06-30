package com.thullyoo.login.system.DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(@NotNull(message = "Nome do produto não pode ser null.") @NotEmpty(message = "Nome do produto não pode ser vazio.") String name,
                             @NotNull(message = "Quantidade no estoque não pode ser null.") @PositiveOrZero(message = "Quantidade no estoque não pode ser negativa") Integer quantity,
                             @NotNull(message = "Preço do produto não pode ser null.") @Positive(message = "Preço não pode ser negativo") Double price) {
}
