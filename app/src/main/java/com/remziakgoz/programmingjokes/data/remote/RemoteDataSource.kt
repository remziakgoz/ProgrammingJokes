package com.remziakgoz.programmingjokes.data.remote

import com.remziakgoz.programmingjokes.data.remote.dto.Jokess
import com.remziakgoz.programmingjokes.util.Constants.PATH_URL
import retrofit2.http.GET


interface RemoteDataSource {

    @GET(PATH_URL)
    suspend fun getJokes(
    ) : Jokess

}