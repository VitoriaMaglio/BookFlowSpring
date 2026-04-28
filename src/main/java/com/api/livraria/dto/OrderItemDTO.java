package com.api.livraria.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {
    @NotNull
    private Long bookId;

    @Positive
    private int quantity;
}
