package com.todolist.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.todolist.api.dtos.TaskDTO;
import com.todolist.api.entities.Task;
import com.todolist.api.repositories.TaskRepository;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public List<Task> create(TaskDTO taskDTO) {        
        Task task = new Task.Builder()
                        .title(taskDTO.title())
                        .description(taskDTO.description())
                        .listEntity(taskDTO.listEntity())
                        .checked(taskDTO.checked())
                        .build();

        taskRepository.save(task);
        return findAll();
    }

    public List<Task> update(TaskDTO taskDTO, Long id) {
        Task task = findById(id);

        if (task != null) {
            Task updateTask = Task.builder(task)
                            .title(taskDTO.title())
                            .description(taskDTO.description())
                            .listEntity(taskDTO.listEntity())
                            .checked(taskDTO.checked())
                            .build();

            updateTask.setId(task.getId());
            taskRepository.save(updateTask);
        }

        return findAll();
    }

    public List<Task> delete(Long id) {
        Task task = findById(id);

        if (task != null) {
            taskRepository.delete(task);
        }

        return findAll();
    }
}
