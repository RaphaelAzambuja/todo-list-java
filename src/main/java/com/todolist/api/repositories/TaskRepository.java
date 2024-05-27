package com.todolist.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todolist.api.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
