package com.remziakgoz.programmingjokes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.remziakgoz.programmingjokes.presentation.jokes.views.JokesScreen
import com.remziakgoz.programmingjokes.presentation.jokes.views.JokesViewModel
import com.remziakgoz.programmingjokes.presentation.ui.theme.ProgrammingJokesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgrammingJokesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    JokesScreen()
                }
            }
        }
    }
}
