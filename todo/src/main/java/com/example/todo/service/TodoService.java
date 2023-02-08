package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount=0;



    static {
        todos.add(new Todo(++todoCount, "Learn SpringBoot",false));
        todos.add(new Todo(++todoCount, "Visit Grocery Store",false));
        todos.add(new Todo(++todoCount, "Learn AWS",false));
        todos.add(new Todo(++todoCount, "hdhdjdhd",false));
        todos.add(new Todo(++todoCount, "Yoga4",false));

    }

    public List<Todo> findAll(){ // business logic
        return todos;

    }
    public Todo findId(int id){ // business logic
        //to be written
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        Todo todo =todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

}
