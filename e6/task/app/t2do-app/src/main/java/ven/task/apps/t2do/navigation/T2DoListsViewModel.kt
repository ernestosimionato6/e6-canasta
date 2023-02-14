package ven.task.apps.t2do.navigation

import androidx.lifecycle.ViewModel

class T2DoListsViewModel(): ViewModel(), T2DoListsVM {


    override fun getTaskLists(): List<TaskList> = dummyTaskLists

}

