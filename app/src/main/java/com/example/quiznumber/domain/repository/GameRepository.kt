package com.example.quiznumber.domain.repository

import com.example.quiznumber.domain.entities.GameSettings
import com.example.quiznumber.domain.entities.Level
import com.example.quiznumber.domain.entities.Question

interface GameRepository {

    fun getGameSettings(level: Level): GameSettings

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question
}