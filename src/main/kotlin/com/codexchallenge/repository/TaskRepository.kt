package com.codexchallenge.repository

import com.codexchallenge.model.TaskModel
import org.springframework.data.repository.CrudRepository

interface TaskRepository: CrudRepository<TaskModel, Int> {

}