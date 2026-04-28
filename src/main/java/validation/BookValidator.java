package validation;

import dto.BookCreateDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookValidator implements ConstraintValidator<ValidBook, BookCreateDTO> {

    @Override
    public boolean isValid(BookCreateDTO dto, ConstraintValidatorContext context) {

        if (dto.getRating() != null && dto.getPrice() != null) {

            if (dto.getRating() > 4.5 && dto.getPrice() < 20) {

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Highly rated books must cost at least 20"
                ).addConstraintViolation();

                return false;
            }
        }

        return true;
    }
}
