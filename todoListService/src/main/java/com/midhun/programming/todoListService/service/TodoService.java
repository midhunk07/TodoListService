package com.midhun.programming.todoListService.service;

import com.midhun.programming.todoListService.model.TodoItem;

public interface TodoService {
	    public TodoItem addItem(TodoItem item);

		

		public TodoItem changeDescription(Integer itemId, String description);
	   
		
		public TodoItem markDone(Integer itemId, boolean isDone, String status);
		
		
	}


