package dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderCreateDTO {
    @NotNull
    private Long customerId;

    @NotEmpty
    private List<OrderItemDTO> items;
}
