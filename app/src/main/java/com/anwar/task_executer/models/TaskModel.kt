package com.anwar.task_executer.models

data class TaskModel(
    val taskId: Int,
    val taskName: String,
    var isSelected: Boolean = false
)