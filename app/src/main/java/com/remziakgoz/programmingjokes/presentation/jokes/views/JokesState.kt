package com.remziakgoz.programmingjokes.presentation.jokes.views

import com.remziakgoz.programmingjokes.domain.model.Joke

data class JokesState(
    val isLoading: Boolean = false,
    val jokes: List<Joke> = emptyList(),
    val error: String = ""
)
