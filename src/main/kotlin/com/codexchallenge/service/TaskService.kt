package com.codexchallenge.service

import com.codexchallenge.controller.requesttask.PostTaskRequest
import com.codexchallenge.model.TaskModel
import org.springframework.stereotype.Service

@Service
class TaskService {

    fun getAll(): TaskModel {
        return TaskModel(0, "Limpar o quarto")
    }

    fun get(id: String): TaskModel {
        //TODO: missing implementation
        return TaskModel(0, "Limpar o quarto com id")
    }

    fun create(task: TaskModel) {
        println(task)
    }

    fun delete(id: String) {
        println("remove by Id")
    }

}