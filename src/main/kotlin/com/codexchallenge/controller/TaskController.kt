package com.codexchallenge.controller

import com.codexchallenge.controller.requesttask.PostTaskRequest
import com.codexchallenge.model.TaskModel
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
class TaskController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): TaskModel {
        return TaskModel("1", "Limpar o quarto")
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable id: String): TaskModel {
        //TODO: missing implementation
        return TaskModel("1", "Limpar o quarto")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody task: PostTaskRequest) {
        println(task)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        println("remove by Id")
    }

}