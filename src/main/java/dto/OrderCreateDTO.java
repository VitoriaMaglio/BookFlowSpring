package dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class OrderCreateDTO {
    @NotNull
    private Long customerId;

    @NotEmpty
    private List<OrderItemDTO> items;
}
