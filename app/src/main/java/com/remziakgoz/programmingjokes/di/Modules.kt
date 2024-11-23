package com.remziakgoz.programmingjokes.di

import com.remziakgoz.programmingjokes.data.remote.RemoteDataSource
import com.remziakgoz.programmingjokes.data.repository.JokeRepositoryImpl
import com.remziakgoz.programmingjokes.domain.repository.JokeRepository
import com.remziakgoz.programmingjokes.domain.usecase.GetJokesUseCase
import com.remziakgoz.programmingjokes.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource() : RemoteDataSource{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideJokeRepositoryImpl(remoteDataSource: RemoteDataSource): JokeRepositoryImpl {
        return JokeRepositoryImpl(remoteDataSource)
    }

    // JokeRepository için eklenen provider
    @Provides
    @Singleton
    fun provideJokeRepository(jokeRepositoryImpl: JokeRepositoryImpl): JokeRepository {
        return jokeRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideGetJokesUseCase(jokeRepository: JokeRepository): GetJokesUseCase {
        return GetJokesUseCase(jokeRepository)
    }
}