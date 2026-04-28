package service.mapper;

import dto.BookDTO;
import entity.Author;
import entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getRating(),
                book.getPrice(),
                book.getAuthors().stream().map(Author::getName).toList()
        );
    }

}
