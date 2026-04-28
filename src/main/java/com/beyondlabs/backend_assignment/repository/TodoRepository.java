package com.beyondlabs.backend_assignment.repository;


import com.beyondlabs.backend_assignment.model.TodoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private final Map<Long, TodoModel> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TodoModel save (TodoModel todoModel){
        if(todoModel.getId()==null){
            todoModel.setId(idGenerator.getAndIncrement());
        }
        store.put(todoModel.getId(),todoModel);
        return todoModel;
    }

    public Optional<TodoModel> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }

    public List<TodoModel> findByUserId(String userId){
        return store.values().stream().filter(t->t.getUserId().equals(userId)).collect(Collectors.toList());
    }
    public List<TodoModel> findAll()
    {
        return new ArrayList<>(store.values());
    }
}
