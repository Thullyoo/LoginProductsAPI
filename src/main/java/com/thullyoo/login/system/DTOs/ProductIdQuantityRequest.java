package com.thullyoo.login.system.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductIdQuantityRequest(@NotNull(message = "Id do produto não pode ser null.") Long productId,
        @NotNull(message = "Quantidade no estoque não pode ser null.") @PositiveOrZero(message = "Quantidade no estoque não pode ser negativa") Integer quantity) {
}
