package com.example.toscas_front.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,

    @SerializedName("vote_average")
    val rate: Double = 0.0,

    @SerializedName("poster_path")
    val posterPath: String?
) {
    val posterUrl: String?
        get() = posterPath
            ?.takeIf { it.isNotBlank() }
            ?.let { "https://image.tmdb.org/t/p/w500$it" }
}

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)