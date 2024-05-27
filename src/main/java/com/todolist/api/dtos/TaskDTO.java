package com.todolist.api.dtos;

import com.todolist.api.entities.ListEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDTO(
    @NotBlank(message = "O título não pode estar em branco")
    String title,

    @NotNull(message = "A entidade da lista não pode ser nula")
    ListEntity listEntity,

    @NotBlank(message = "A descrição não pode estar em branco")
    String description,

    @NotNull(message = "A flag 'checked' não pode ser nula")
    Boolean checked
) {}
