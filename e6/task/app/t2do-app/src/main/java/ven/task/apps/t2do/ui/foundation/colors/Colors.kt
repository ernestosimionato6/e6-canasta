package ven.task.apps.t2do.ui.foundation.colors

import androidx.compose.ui.graphics.Color
import ven.task.core.model.Priority
import ven.task.core.model.Priority.HIGH
import ven.task.core.model.Priority.LOW
import ven.task.core.model.Priority.MEDIUM

/** PRIORITY COLORS **/

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)


fun toColor(priority: Priority) = when (priority) {
        HIGH -> HighPriorityColor
        MEDIUM -> MediumPriorityColor
        LOW -> LowPriorityColor
        else -> {
            NonePriorityColor
        }
}
