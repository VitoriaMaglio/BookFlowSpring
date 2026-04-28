package com.api.livraria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorCreateDTO {


    @NotBlank
    private String name;
}
