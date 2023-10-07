package com.codexchallenge.model

import jakarta.persistence.*

@Entity(name = "task")
data class TaskModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "task_description")
        var taskDescription: String
)