package com.davidcorrado.kotlinrest.controller

import com.davidcorrado.kotlinrest.data.Task
import com.davidcorrado.kotlinrest.data.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping( "/api/v1/tasks")
class TaskController {
    @Autowired lateinit var taskRepo: TaskRepository

    @GetMapping()
    fun getAll(): Iterable<Task> {
        return taskRepo.findAll()
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): Task {
        if(taskRepo.existsById(id)) {
            return taskRepo.findById(id).get()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND,"Task not found.")
        }
    }

    @PostMapping()
    fun save(@RequestBody task: Task): Task {
        return taskRepo.save(task)
    }

    @DeleteMapping()
    fun deleteAll() {
        taskRepo.deleteAll()
    }

    @DeleteMapping("/{id}")
    fun deleteByID(@PathVariable id: Long) {
        if(taskRepo.existsById(id)) {
            taskRepo.deleteById(id)
        }
    }
}