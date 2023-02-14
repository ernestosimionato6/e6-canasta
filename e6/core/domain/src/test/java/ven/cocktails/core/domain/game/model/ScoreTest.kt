package ven.cocktails.core.domain.game.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ScoreTest {

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val score = Score()

        score.increment()

        assertEquals(
            "Current score should have been 1",
            1,
            score.current
        )
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val score = Score()

        score.increment()

        assertEquals(
            "High score should have ben 10",
            1,
            score.highest
        )
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHightScore() {
        val score = Score(10)

        score.increment()

        assertEquals(
            "High score should have been 10",
            10,
            score.highest
        )
    }
}