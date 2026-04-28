package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookDTO {

    private Long id;
    private String title;
    private Double rating;
    private Double price;
    private List<String> authors;

    public BookDTO(Long id, String title, Double rating, Double price, List<String> list) {
    }
}
