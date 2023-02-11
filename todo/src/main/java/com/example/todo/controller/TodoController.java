package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
CREATE TODO, DELETE TODO, UPDATE TODO, FETCH TODO(CRUD OPERATIONS)
 */
@RestController
@RequestMapping("api/v1/todo-app")
public class TodoController {

  private  final TodoService todoService;
  public TodoController(TodoService todoService){

    this.todoService=todoService;
  }
  @PostMapping("/add-todo")
    public void addTodo(@RequestBody Todo todo){
         todoService.addTodo(todo);
    }
    //http://localhost:8080/api/v1/todo-app/find-todo/id/5
    @GetMapping("/find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){
      return todoService.findId(id);

    }
    //http://localhost:8080/api/v1/todo-app/find-all
    @GetMapping("find-all")
    public List<Todo> findAllTodos(){
      return todoService.findAll();

    }
    // @RequestMapping(value="url", method=HttpRequest.PUT)
    @PutMapping("update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
   todoService.updateTodo(id,todo);
    }
    @DeleteMapping("delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }

    /*@RequestMapping("/api")

    public String helloUser(@RequestParam String username){
        return "hello " + username;
    } */



    /* @RequestMapping("/message")
    public String msg(){
        return "hello";
    }

    @RequestMapping("/api/username/{username}")
    public String helloUser(@PathVariable String username){
        return "hello " + username;
    }*/

}
