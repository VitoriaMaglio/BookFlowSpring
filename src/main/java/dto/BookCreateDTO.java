package dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookCreateDTO {

    @NotBlank
    private String title;

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Double rating;

    @Positive
    private Double price;

    @NotEmpty
    private List<Long> authorIds;
}
