package com.api.livraria.service.mapper;

import com.api.livraria.dto.BookDTO;
import com.api.livraria.entity.Author;
import com.api.livraria.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
