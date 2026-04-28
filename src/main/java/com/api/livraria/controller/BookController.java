package com.api.livraria.controller;

import com.api.livraria.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.livraria.projection.BookSimpleProjection;
import com.api.livraria.repository.BookRepository;
import com.api.livraria.repository.OrderItemRepository;
import com.api.livraria.service.BookService;
import com.api.livraria.service.mapper.BookMapper;
import com.api.livraria.dto.BookCreateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService service;
    @Autowired private BookRepository repo;
    @Autowired private BookMapper mapper;
    @Autowired
    private OrderItemRepository orderItemRepo;

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody @Valid BookCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDTO(service.create(dto)));
    }

    @GetMapping
    public Page<BookDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDTO);
    }

    @GetMapping("/search/title")
    public Page<BookDTO> searchByTitle(
            @RequestParam String title,
            Pageable pageable) {

        return repo.findByTitleContainingIgnoreCase(title, pageable)
                .map(mapper::toDTO);
    }

    @GetMapping("/simple")
    public Page<BookSimpleProjection> simple(Pageable pageable) {
        return repo.findSimpleBooks(pageable);
    }

    @GetMapping("/search/rating")
    public Page<BookDTO> searchByRating(
            @RequestParam Double rating,
            Pageable pageable) {

        return repo.findByRatingGreaterThanEqual(rating, pageable)
                .map(mapper::toDTO);
    }

    @GetMapping("/search/author")
    public Page<BookDTO> searchByAuthor(
            @RequestParam String name,
            Pageable pageable) {

        return repo.findByAuthorName(name, pageable)
                .map(mapper::toDTO);
    }

    @GetMapping("/search/avg-price")
    public List<BookDTO> booksByAvgPrice(@RequestParam BigDecimal avgPrice) {

        return orderItemRepo.findBooksWithAvgPriceGreaterThan(avgPrice)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

}
