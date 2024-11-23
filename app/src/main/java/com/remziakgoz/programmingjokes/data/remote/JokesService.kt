package com.remziakgoz.programmingjokes.data.remote

import com.remziakgoz.programmingjokes.util.Constants.PATH_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

/*class JokesService @Inject constructor(): KtorApi() {
    suspend fun getJokes(): JokesResponse = client.get {
        pathUrl(PATH_URL)
    }.body()
}

 */