package com.example.toscas_front.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toscas_front.BuildConfig
import com.example.toscas_front.data.model.Movie
import com.example.toscas_front.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel(){
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    val apikey = BuildConfig.API_KEY

    var currentPage = 1

    fun fetchMovies(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.movieApi.discoverMovies(
                    token =  apikey,
                    page = currentPage
                )

                _movies.value += response.results
                currentPage++
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}