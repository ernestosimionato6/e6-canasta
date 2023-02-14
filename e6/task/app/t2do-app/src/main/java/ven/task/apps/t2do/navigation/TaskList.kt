package ven.task.apps.t2do.navigation

data class TaskList(
    val id: String,
    val title: String,
   val tasks: List<Task>
)
