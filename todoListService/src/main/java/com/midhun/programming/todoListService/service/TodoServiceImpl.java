package com.midhun.programming.todoListService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midhun.programming.todoListService.model.Status;
import com.midhun.programming.todoListService.model.TodoItem;
import com.midhun.programming.todoListService.repository.TodoItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public TodoItem addItem(TodoItem item) {
        return todoItemRepository.save(item);
    }

	@Override
	public TodoItem changeDescription(Integer itemId, String description) {
		
		Optional<TodoItem> itemResponse = todoItemRepository.findByItemId(itemId);
        TodoItem item = null;
        if(itemResponse.isPresent()){
            item = itemResponse.get();
            item.setDescription(description);
        }
        return addItem(item);
	}
	
	 @Override
	    public TodoItem markItem(Integer itemId, boolean isDone, String status) {
	        Optional<TodoItem> itemResponse = todoItemRepository.findByItemId(itemId);
	        TodoItem item = null;
	        if(itemResponse.isPresent()){
	            item = itemResponse.get();
	            item.setStatus(status != null && status.equals(Status.past_due.getStatus())? Status.past_due.getStatus() : isDone ? Status.done.getStatus() : Status.not_done.getStatus());
	        }
	        return todoItemRepository.save(item);
	    }  

	   @Override
	    public Iterable<TodoItem> getAllItems(Optional<String> status) {
	        if(status.isPresent()) {
	            return todoItemRepository.findByItemStatus(status);
	        } else {
	            return todoItemRepository.findAll();
	        }
	    }
	   
	   @Override
	    public Optional<TodoItem> getItemsById(Integer itemId) {
	        return todoItemRepository.findByItemId(itemId);
	    }

   
}
