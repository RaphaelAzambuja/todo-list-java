package com.todolist.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.api.models.ListEntity;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {}
