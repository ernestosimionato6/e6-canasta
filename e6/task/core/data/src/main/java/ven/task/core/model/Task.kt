package ven.task.core.model

data class Task(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)