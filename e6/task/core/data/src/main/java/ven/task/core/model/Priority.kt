package ven.task.core.model

import ven.task.core.model.Color.BLUE
import ven.task.core.model.Color.GREEN
import ven.task.core.model.Color.WHITE
import ven.task.core.model.Color.YELLOW

enum class Color {
    YELLOW,
    GREEN,
    WHITE,
    BLUE;
}

enum class Priority(val color: Color) {

    HIGH(GREEN),
    MEDIUM(WHITE),
    LOW(BLUE),
    NONE(YELLOW);

}
