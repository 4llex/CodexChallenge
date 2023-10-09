package com.codexchallenge.controller

import com.codexchallenge.controller.requesttask.PostTaskRequest
import com.codexchallenge.extension.toTaskModel
import com.codexchallenge.model.TaskModel
import com.codexchallenge.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tasks")
class TaskController(
        var taskService: TaskService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<TaskModel> {
        return taskService.getAll()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTask(@PathVariable id: Int): TaskModel {
        return taskService.getTask(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody task: PostTaskRequest) {
        taskService.create(task.toTaskModel())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        taskService.delete(id)
    }

}