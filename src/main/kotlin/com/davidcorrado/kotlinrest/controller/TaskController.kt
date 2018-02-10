package com.davidcorrado.kotlinrest.controller

import com.davidcorrado.kotlinrest.data.Task
import com.davidcorrado.kotlinrest.data.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping( "/api/v1/task")
class TaskController {

    @Autowired lateinit var taskRepo: TaskRepository

    @GetMapping()
    fun getAll(): Any {
        return taskRepo.findAll()
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long) {
        taskRepo.findOne(id)
    }

    @PostMapping()
    fun save(@RequestParam task: Task): Any {
        return taskRepo.save(task)
    }

    @DeleteMapping()
    fun deleteAll() {
        taskRepo.deleteAll()
    }

    @DeleteMapping("/{id}")
    fun deleteByID(@PathVariable id: Long) {
        taskRepo.delete(id)
    }
}