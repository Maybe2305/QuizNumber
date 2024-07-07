package com.example.quiznumber.domain.usecases

import com.example.quiznumber.domain.entities.Question
import com.example.quiznumber.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(COUNT_OF_OPTIONS, maxSumValue)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}