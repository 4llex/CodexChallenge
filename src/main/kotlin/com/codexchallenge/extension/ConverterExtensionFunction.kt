package com.codexchallenge.extension

import com.codexchallenge.controller.requestcnpj.PostCnpjRequest
import com.codexchallenge.controller.requesttask.PostTaskRequest
import com.codexchallenge.model.CnpjModel
import com.codexchallenge.model.TaskModel

fun PostCnpjRequest.toCnpjModel(): CnpjModel {
    return CnpjModel(cnpj = this.cnpj, isValid = false)
}

fun PostTaskRequest.toTaskModel(): TaskModel {
    return TaskModel(taskDescription = this.taskDescription)
}