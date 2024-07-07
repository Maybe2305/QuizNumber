package com.example.quiznumber.domain.usecases

import com.example.quiznumber.domain.entities.GameSettings
import com.example.quiznumber.domain.entities.Level
import com.example.quiznumber.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}