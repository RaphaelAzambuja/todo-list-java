package com.todolist.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todolist.api.models.TaskEntity;
import com.todolist.api.models.dtos.TaskDTO;
import com.todolist.api.repositories.TaskRepository;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public TaskEntity findById(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public List<TaskEntity> create(TaskDTO taskDTO) {        
        TaskEntity task = new TaskEntity.Builder()
                        .title(taskDTO.title())
                        .description(taskDTO.description())
                        .checked(taskDTO.checked())
                        .listEntity(taskDTO.listEntity())
                        .build();

        taskRepository.save(task);
        return findAll();
    }

    public List<TaskEntity> update(TaskDTO taskDTO, Long id) {
        TaskEntity task = findById(id);

        if (task != null) {
            TaskEntity updateTask = TaskEntity.builder(task)
                            .title(taskDTO.title())
                            .description(taskDTO.description())
                            .checked(taskDTO.checked())
                            .listEntity(taskDTO.listEntity())
                            .build();

            updateTask.setId(task.getId());
            taskRepository.save(updateTask);
        }

        return findAll();
    }

    public List<TaskEntity> delete(Long id) {
        TaskEntity task = findById(id);

        if (task != null) {
            taskRepository.delete(task);
        }

        return findAll();
    }
}
