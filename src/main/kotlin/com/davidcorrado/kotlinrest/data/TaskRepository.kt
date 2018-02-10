package com.davidcorrado.kotlinrest.data

import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}