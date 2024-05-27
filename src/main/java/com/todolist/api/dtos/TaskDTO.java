package com.todolist.api.dtos;

import com.todolist.api.entities.ListEntity;

public record TaskDTO(String title, ListEntity listEntity, String description, Boolean checked) {}
