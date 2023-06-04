package com.midhun.programming.todoListService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midhun.programming.todoListService.model.TodoItem;
import com.midhun.programming.todoListService.repository.TodoItemRepository;

import lombok.extern.slf4j.Slf4j;


import java.util.Optional;

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
	
	  

	
   
}
