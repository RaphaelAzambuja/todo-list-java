package com.todolist.api.dtos;

import com.todolist.api.entities.List;

public record TaskDTO(String title, List listEntity, String description, Boolean checked) {}
