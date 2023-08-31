package com.todo.demotodo.controllers

import com.todo.demotodo.entities.Todo
import com.todo.demotodo.entities.TodoRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository) {

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @GetMapping("/{todoId}")
    fun getToDo(@PathVariable("todoId") todoId: Long): Optional<Todo> {
        return todoRepository.findById(todoId)
    }

    @PutMapping("/{todoId}")
    fun updateToDo(@PathVariable("todoId") todoId: Long, @RequestBody updateTodo: Todo): Todo? {
        val oldTodo = todoRepository.findById(todoId)

        if(oldTodo == null) {
            return oldTodo
        }

        return todoRepository.save(updateTodo)
    }

    @DeleteMapping("/{todoId}")
    fun deleteToDo(@PathVariable("todoId") todoId: Long) {
        todoRepository.deleteById(todoId)
    }
}