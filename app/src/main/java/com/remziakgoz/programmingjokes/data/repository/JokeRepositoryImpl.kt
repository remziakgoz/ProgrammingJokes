package com.remziakgoz.programmingjokes.data.repository

import com.remziakgoz.programmingjokes.data.remote.RemoteDataSource
import com.remziakgoz.programmingjokes.data.remote.dto.Jokess
import com.remziakgoz.programmingjokes.data.util.toJoke
import com.remziakgoz.programmingjokes.domain.model.Joke
import com.remziakgoz.programmingjokes.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : JokeRepository {
    override suspend fun getJokes(): Jokess {
        return remoteDataSource.getJokes()
    }
}