package controller;

import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.BookRepository;
import service.BookService;
import service.mapper.BookMapper;
import dto.BookCreateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService service;
    @Autowired private BookRepository repo;
    @Autowired private BookMapper mapper;

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody @Valid BookCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDTO(service.create(dto)));
    }

    @GetMapping
    public Page<BookDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDTO);
    }

}
