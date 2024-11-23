package com.remziakgoz.programmingjokes.data.util

import com.remziakgoz.programmingjokes.data.remote.dto.JokessItem
import com.remziakgoz.programmingjokes.domain.model.Joke


fun JokessItem.toJoke(): Joke {
    return Joke(joke,delivery,setup,type)
}