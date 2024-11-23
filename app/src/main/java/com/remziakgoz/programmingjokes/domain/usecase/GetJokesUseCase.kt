    package com.remziakgoz.programmingjokes.domain.usecase

    import com.remziakgoz.programmingjokes.data.remote.dto.Jokess
    import com.remziakgoz.programmingjokes.data.remote.dto.JokessItem
    import com.remziakgoz.programmingjokes.data.util.toJoke
    import com.remziakgoz.programmingjokes.domain.model.Joke
    import com.remziakgoz.programmingjokes.domain.repository.JokeRepository
    import com.remziakgoz.programmingjokes.util.ApiResponse
    import com.remziakgoz.programmingjokes.util.Status
    import kotlinx.coroutines.flow.Flow
    import kotlinx.coroutines.flow.flow
    import javax.inject.Inject

    class GetJokesUseCase @Inject constructor(private val repository: JokeRepository) {

        fun executeGetJokes() : Flow<ApiResponse<List<Joke>>> = flow {
            emit(ApiResponse(Status.LOADING))

            try {
               val jokes = repository.getJokes()
                emit(ApiResponse(Status.SUCCESS, jokes.map { it.toJoke() }))

            } catch (e: Exception) {
                emit(ApiResponse(Status.ERROR, null, message = e.localizedMessage ?: "An error occurred"))
            }

        }

    }