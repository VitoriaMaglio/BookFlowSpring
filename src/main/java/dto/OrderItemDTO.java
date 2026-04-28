package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemDTO {
    @NotNull
    private Long bookId;

    @Positive
    private int quantity;
}
