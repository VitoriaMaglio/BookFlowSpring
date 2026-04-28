package com.api.livraria.controller;

import com.api.livraria.dto.CustomerDTO;
import com.api.livraria.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.livraria.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerDTO dto) {

        Customer c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(c));
    }

    @GetMapping
    public Page<Customer> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/search")
    public Page<Customer> search(@RequestParam String name, Pageable pageable) {
        return repo.findByNameContainingIgnoreCase(name, pageable);
    }

}
