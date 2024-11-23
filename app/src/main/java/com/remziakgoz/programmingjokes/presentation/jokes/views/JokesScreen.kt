package com.remziakgoz.programmingjokes.presentation.jokes.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun JokesScreen(
    viewModel: JokesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.jokes) { joke ->
                JokeListRow(joke = joke)
            }
        }
    }
}