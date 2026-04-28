package com.beyondlabs.backend_assignment.service;

import com.beyondlabs.backend_assignment.model.TodoModel;
import com.beyondlabs.backend_assignment.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TodoService {
   private final TodoRepository todoRepository;

   public TodoModel createTodo(String title,String description,String userId,String status,String tokenUserId,String role){
       if(!role.equals("ADMIN") && !tokenUserId.equals(userId)){
           throw new RuntimeException("Forbidden");
       }

       TodoModel todoModel= new TodoModel();

       todoModel.setUserId(userId);
       todoModel.setTitle(title);

       todoModel.setDescription(description);
       todoModel.setCreatedAt(LocalDateTime.now());
       todoModel.setUpdatedAt(LocalDateTime.now());

       return todoRepository.save(todoModel);
   }

   public List<TodoModel> getMy

}
