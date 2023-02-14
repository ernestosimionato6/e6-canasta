package ven.task.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_tasks")
data class Task(
   @PrimaryKey(autoGenerate = true)
   val id: Int = 0,
   val title: String,
   val description: String,
   val priority: Priority,
)