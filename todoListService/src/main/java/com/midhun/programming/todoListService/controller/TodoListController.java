package com.midhun.programming.todoListService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.midhun.programming.todoListService.model.TodoItem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.midhun.programming.todoListService.service.TodoService;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoListController {
    @Autowired
    private TodoService todoService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> addItem(@RequestBody TodoItem item) throws Exception {
        return ResponseEntity.ok(todoService.addItem(item));
    }
    @PutMapping(value = "/changeDescription", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> changeDescription(@RequestParam Integer itemId, String description){;
    return ResponseEntity.ok(todoService.changeDescription(itemId, description));
    }
    
    @PostMapping(value = "/markItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> markItem(@RequestParam Integer itemId, boolean isDone){
        return ResponseEntity.ok(todoService.markItem(itemId, isDone, null));
    }
    
    @GetMapping(value = "/getAllItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<TodoItem>> getAllItems(@RequestParam Optional<String> status) {
        return ResponseEntity.ok(todoService.getAllItems(status));
    }
    
    @GetMapping(value = "/getItemsById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<TodoItem>> getItemsById(@RequestParam Integer itemId) {
        return ResponseEntity.ok(todoService.getItemsById(itemId));
    }


    

}
