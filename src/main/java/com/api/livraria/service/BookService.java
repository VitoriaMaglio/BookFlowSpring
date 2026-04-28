package com.api.livraria.service;

import com.api.livraria.dto.BookCreateDTO;
import com.api.livraria.entity.Author;
import com.api.livraria.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.livraria.repository.AuthorRepository;
import com.api.livraria.repository.BookRepository;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;

    public Book create(BookCreateDTO dto) {

        List<Author> authors = authorRepo.findAllById(dto.getAuthorIds());

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setRating(dto.getRating());
        book.setPrice(dto.getPrice());
        book.setAuthors(authors);

        return bookRepo.save(book);
    }

}
