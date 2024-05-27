package com.todolist.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.todolist.api.dtos.ListDTO;
import com.todolist.api.entities.ListEntity;
import com.todolist.api.services.ListService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("list")
public class ListController {

    ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    public List<ListEntity> getAll() {
        return listService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ListEntity> getById(@PathVariable Long id) {
        var list = listService.findById(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public List<ListEntity> create(@RequestBody @Valid ListDTO listDTO) {
        return listService.create(listDTO);
    }

    @PostMapping("/{id}")
    public List<ListEntity> update(@RequestBody @Valid ListDTO listDTO, @PathVariable Long id) {
        return listService.update(listDTO, id);
    }

    @DeleteMapping("/{id}")
    public List<ListEntity> delete(@PathVariable Long id) {
        return listService.delete(id);
    }
}
