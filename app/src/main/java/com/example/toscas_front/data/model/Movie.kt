package com.example.toscas_front.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,

    @SerializedName("voto_average")
    val rate: Double = 0.0,

    @SerializedName("poster_path")
    val posterPath: String?
)

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)