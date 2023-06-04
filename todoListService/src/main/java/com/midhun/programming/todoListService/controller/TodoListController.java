package com.midhun.programming.todoListService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.midhun.programming.todoListService.model.TodoItem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midhun.programming.todoListService.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoListController {
    @Autowired
    private TodoService todoService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> addItem(@RequestBody TodoItem item) throws Exception {
        return ResponseEntity.ok(todoService.addItem(item));
    }

}
