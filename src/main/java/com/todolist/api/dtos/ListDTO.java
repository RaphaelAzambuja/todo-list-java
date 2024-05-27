package com.todolist.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ListDTO(
    @NotBlank(message = "O título não pode estar em branco")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
    String title,
    
    @NotBlank(message = "A descrição não pode estar em branco")
    String description
) {}
