package com.todolist.api.models.dtos;

import com.todolist.api.models.ListEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDTO(
    @NotBlank(message = "O título não pode estar em branco")
    String title,

    @NotBlank(message = "A descrição não pode estar em branco")
    String description,

    @NotNull(message = "A flag 'checked' não pode ser nula")
    Boolean checked,

    @NotNull(message = "A tarefa deve ser atribuida a uma lista de tarefas")
    ListEntity listEntity
) {}
