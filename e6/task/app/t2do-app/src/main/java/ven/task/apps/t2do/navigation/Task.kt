package ven.task.apps.t2do.navigation

import ven.task.apps.t2do.navigation.TaskPriority.LOW

data class Task(
    val id: TaskId = TaskId.next(), // TaskId.NONE,
    val name: String,
    val priority: TaskPriority = LOW,
    val status: TaskStatus = TaskStatus.DRAFT
)