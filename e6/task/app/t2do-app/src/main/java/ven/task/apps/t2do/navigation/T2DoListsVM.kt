package ven.task.apps.t2do.navigation

interface T2DoListsVM {


    fun getTaskLists(): List<TaskList>

}

val dummyTaskLists: List<TaskList> = listOf(
   TaskList(
       "task-list-123",
       "Projecto Canastas",
       listOf(
           Task(name="Crear canasta app"),
           Task(name="Crear canasta api"),
           Task(name="Crear canasta backoffice")
       )
   )
)
