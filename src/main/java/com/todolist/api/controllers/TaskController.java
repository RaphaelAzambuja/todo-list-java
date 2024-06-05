package com.todolist.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.todolist.api.models.TaskEntity;
import com.todolist.api.models.dtos.TaskDTO;
import com.todolist.api.services.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("task")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntity> getAll() {
        return taskService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getById(@PathVariable Long id) {
        var task = taskService.findById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public List<TaskEntity> create(@RequestBody @Valid TaskDTO taskDTO) {
        return taskService.create(taskDTO);
    }

    @PostMapping("/{id}")
    public List<TaskEntity> update(@RequestBody @Valid TaskDTO taskDTO, @PathVariable Long id) {
        return taskService.update(taskDTO, id);
    }

    @DeleteMapping("/{id}")
    public List<TaskEntity> delete(@PathVariable Long id) {
        return taskService.delete(id);
    }
}
