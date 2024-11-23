package com.remziakgoz.programmingjokes.data.remote

private val BASE_URL = "https://raw.githubusercontent.com/"
private val PATH_URL = "atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json"











/*
abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
        }
    }

}

 */