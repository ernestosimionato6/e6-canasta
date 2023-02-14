package ven.cocktails.core.domain.game.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {

    private lateinit var question: Question

    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }

    // CREATION A QUESTION
    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        assertNull("Answered option should have been null", question.answeredOption)
    }


    // ANSWER QUESTION //
    @Test
    fun whenAnswering_shouldHaveAnsweredOption() {
        question.answer("INCORRECT")
        assertEquals("Answered option should have been INCORRECT","INCORRECT", question.answeredOption)
    }


    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue() {
        val result = question.answer("CORRECT")
        assertTrue("Result of correct answering have been TRUE", result)
    }

    @Test
    fun whenAnswering_withInCorrectOption_shouldReturnFalse() {
        val result = question.answer("INCORRECT")
        assertFalse("Result of incorrect answering have been FALSE", result)
    }

}