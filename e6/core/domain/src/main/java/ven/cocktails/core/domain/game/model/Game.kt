package ven.cocktails.core.domain.game.model

class Game(
    private val questions: List<Question>,
    private val score: Score = Score(0)
) {
    // private val score = Score(highest)


    constructor(
        questions: List<Question>
    ) : this(questions, Score(0))

    constructor(
        questions: List<Question>,
        highest: Int = 0
    ) : this(questions, Score(highest))


    val currentScore: Int
        get() = score.highest

    val highestScore: Int
        get() = score.highest

    private  var questionIndex = -1

    fun incrementScore() {
        score.increment()
    }

    fun answer(question: Question, option: String) {
        val result = question.answer(option)
        if (result) {
            incrementScore()
        }
    }
}
