package com.remziakgoz.programmingjokes.presentation.jokes.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remziakgoz.programmingjokes.domain.usecase.GetJokesUseCase
import com.remziakgoz.programmingjokes.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    private val _state = mutableStateOf<JokesState>(JokesState())
    val state: State<JokesState> = _state

    private var job: Job? = null

    init {
        getJokes()
    }

    private fun getJokes() {
        job?.cancel()
        job = getJokesUseCase.executeGetJokes().onEach {
            when (it.status) {
                Status.SUCCESS -> {
                    _state.value = JokesState(jokes = it.data ?: emptyList())
                }

                Status.ERROR -> {
                    _state.value = JokesState(error = it.message ?: "Error")
                }

                Status.LOADING -> {
                    _state.value = JokesState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }


}