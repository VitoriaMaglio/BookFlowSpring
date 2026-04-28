package controller;

import dto.AuthorCreateDTO;
import entity.Author;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repo;

    @PostMapping
    public Author create(@RequestBody @Valid AuthorCreateDTO dto) {
        Author a = new Author();
        a.setName(dto.getName());
        return repo.save(a);
    }

    @GetMapping
    public Page<Author> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/search")
    public Page<Author> search(@RequestParam String name, Pageable pageable) {
        return repo.findByNameContainingIgnoreCase(name, pageable);
    }

}
