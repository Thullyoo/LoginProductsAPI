package com.thullyoo.login.system.DTOs;

import com.thullyoo.login.system.entities.product.Product;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderResponse(List<ProductOrderResponse> products, Double total) {
}
