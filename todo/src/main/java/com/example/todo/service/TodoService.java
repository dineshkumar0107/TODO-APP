package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;




@Service
public class TodoService implements ITodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount=0;



    static {


    }
@Override
    public List<Todo> findAll(){ // business logic
        return todos;

    }
    @Override
    public Todo findId(int id){ // business logic
        //to be written
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        Todo todo =todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    @Override
    public void addTodo(Todo todo){

        todos.add(todo);
    }
    @Override
 public void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo-> todo.getId()==id;
        todos.removeIf(predicate);
 }
    @Override
 public void updateTodo(int id,Todo newTodo){
        Todo todo = findId(id);
        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());
 }
}
