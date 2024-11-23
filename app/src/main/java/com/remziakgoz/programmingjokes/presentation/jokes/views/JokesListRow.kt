package com.remziakgoz.programmingjokes.presentation.jokes.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.remziakgoz.programmingjokes.domain.model.Joke
import com.remziakgoz.programmingjokes.presentation.ui.theme.ProgrammingJokesTheme

@Composable
fun JokeListRow(joke: Joke) {
    fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
        factory = {
            val density = LocalDensity.current
            val strokeWidthPx = density.run { strokeWidth.toPx() }

            Modifier.drawBehind {
                val width = size.width
                val height = size.height - strokeWidthPx/2

                drawLine(
                    color = color,
                    start = Offset(x = 0f, y = height),
                    end = Offset(x = width , y = height),
                    strokeWidth = strokeWidthPx
                )
            }
        }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .bottomBorder(5.dp, Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Eğer type 'single' ise yalnızca joke göster
        if (joke.type == "single") {
            Text(
                text = joke.joke?: "joke",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(14.dp)
            )
        }
        // Eğer type 'two part' ise setup ve delivery göster
        else  {
            Text(
                text = joke.setup?: "setup",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(14.dp)
            )
            Spacer(modifier = Modifier.height(8.dp)) // Setup ve delivery arasına boşluk ekleyebilirsiniz
            Text(
                text = joke.delivery?: "delivery",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(14.dp)
            )
        }
    }
}

