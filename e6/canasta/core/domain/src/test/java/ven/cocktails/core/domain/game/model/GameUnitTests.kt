package ven.cocktails.core.domain.game.model

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.never
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GameUnitTests {

    //  INCREMENTING SCORE  //

    class IncrementingTests {
        @Test
        fun WheIncrementingScore_shouldIncrementCurrentScore() {
            val game = Game(emptyList(), 0)

            game.incrementScore()

            assertEquals(
                "Current score should have been 1",
                1,
                game.currentScore
            )
        }

        @Test
        fun WhenIncrementingScore_aboveHighscore_shouldAlsoIncrementHighScore() {
            val game = Game(emptyList(), 0)

            game.incrementScore()

            assertEquals(
                "Highest score should have been 1",
                1,
                game.highestScore
            )
        }

        @Test
        fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
            val game = Game(emptyList(), 10)

            game.incrementScore()

            assertEquals(
                "Highest score should have been 10",
                10,
                game.highestScore
            )
        }
    }

    class AnsweringTests {

        @Test
        fun whenAnsweringCorrectly_shouldIncrementCurrentScore() {
            val question = mock<Question>()
            whenever(question.answer(anyString())).thenReturn(true)
            val score = spy<Score>(Score(0))


            val game = Game(listOf(question), score)

            game.answer(question, "OPTION")

            assertEquals(
                "Current score should have been 1",
                1,
                game.currentScore
            )
            verify(score).increment()
        }

        @Test
        fun whenAnsweringIncorrectly_shouldNotIncrementCurrentScore() {
            val question = mock<Question>()
            whenever(question.answer(anyString())).thenReturn(false)
            val score = spy<Score>(Score(0))

            val game = Game(listOf(question), score)

            game.answer(question, "OPTION")

            assertEquals(
                "Current score should have been 0",
                0,
                game.currentScore
            )
            verify(score, never()).increment()
        }

    }

}