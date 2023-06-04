package com.midhun.programming.todoListService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.midhun.programming.todoListService.model.TodoItem;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, String> {

    @Query(value = "SELECT t from TodoItem t where t.status = ?1")
    Iterable<TodoItem> findByItemStatus(Optional<String> status);

    @Query(value = "SELECT t from TodoItem t where t.id = ?1")
    Optional<TodoItem> findByItemId(Integer itemId);
}
