package com.codexchallenge.service

import com.codexchallenge.model.TaskModel
import com.codexchallenge.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(
        var taskRepository: TaskRepository
) {

    fun getAll(): List<TaskModel> {
        return taskRepository.findAll().toList()
    }

    fun getTask(id: Int): TaskModel {
        return taskRepository.findById(id).orElseThrow()//TODO: tratar erro quando nao existir o Id no db
    }

    fun create(task: TaskModel) {
        taskRepository.save(task)
    }

    fun delete(id: Int) {
        if (!taskRepository.existsById(id)) {
            throw Exception()
        }
        taskRepository.deleteById(id)
    }

}