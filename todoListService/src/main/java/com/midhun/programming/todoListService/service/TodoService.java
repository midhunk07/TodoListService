package com.midhun.programming.todoListService.service;

import java.util.Optional;

import com.midhun.programming.todoListService.model.TodoItem;

public interface TodoService {
	    public TodoItem addItem(TodoItem item);

		

		public TodoItem changeDescription(Integer itemId, String description);
	   
		
		public TodoItem markItem(Integer itemId, boolean isDone, String status);
		
		public Iterable<TodoItem> getAllItems(Optional<String> status);
		
		 public Optional<TodoItem> getItemsById(Integer itemId);
	}


