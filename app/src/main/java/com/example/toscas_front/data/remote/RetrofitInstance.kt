package com.example.toscas_front.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val baseUrl = "https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieApi: MovieApi = retrofit.create(MovieApi::class.java)
}