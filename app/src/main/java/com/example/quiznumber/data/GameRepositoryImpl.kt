package com.example.quiznumber.data

import com.example.quiznumber.domain.entities.GameSettings
import com.example.quiznumber.domain.entities.Level
import com.example.quiznumber.domain.entities.Question
import com.example.quiznumber.domain.repository.GameRepository
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> GameSettings(
                10,
                3,
                10,
                10
            )
            Level.EASY -> GameSettings(
                10,
                10,
                60,
                60
            )
            Level.NORMAL -> GameSettings(
                100,
                15,
                80,
                60
            )
            Level.HARD -> GameSettings(
                1000,
                20,
                90,
                60
            )
        }
    }

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(MIN_ANSWER_VALUE, sum))
        }
        return Question(sum, visibleNumber, options.toList())
    }
}