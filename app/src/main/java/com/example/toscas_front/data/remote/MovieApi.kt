package com.example.toscas_front.data.remote

import com.example.toscas_front.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "pt-BR",
        @Query("vote_count.gte") minimumVotes: Int = 100,
        @Query("page") page: Int = 1
    ) : MovieResponse
}