package com.remziakgoz.programmingjokes.domain.repository

import com.remziakgoz.programmingjokes.data.remote.dto.Jokess
import com.remziakgoz.programmingjokes.domain.model.Joke

interface JokeRepository {
    suspend fun getJokes(): Jokess
}