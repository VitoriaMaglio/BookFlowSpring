package dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import validation.ValidBook;

import java.util.List;
@Getter
@Setter
@ValidBook
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
