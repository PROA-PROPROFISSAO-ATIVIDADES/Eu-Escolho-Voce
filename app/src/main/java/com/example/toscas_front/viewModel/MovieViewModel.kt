package com.example.toscas_front.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toscas_front.BuildConfig
import com.example.toscas_front.data.model.Movie
import com.example.toscas_front.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class MovieUiState(
    val movies: List<Movie> = emptyList(),
    val seenMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val nextPage: Int = 1
)

class MovieViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState = _uiState.asStateFlow()
    private var requestInFlight = false

    fun fetchMovies() {
        if (requestInFlight) return
        if (BuildConfig.API_KEY.isBlank()) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                error = "A chave da API não foi configurada."
            )
            return
        }

        requestInFlight = true
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.movieApi.discoverMovies(
                    apiKey = BuildConfig.API_KEY,
                    page = _uiState.value.nextPage
                )
                val newMovies = response.results
                    .filter { it.id > 0 && it.title.isNotBlank() }
                    .shuffled()
                val currentMovies = _uiState.value.movies
                _uiState.value = _uiState.value.copy(
                    movies = (currentMovies + newMovies).distinctBy { it.id },
                    isLoading = false,
                    nextPage = response.page + 1,
                    error = if (newMovies.isEmpty()) {
                        "A API não retornou filmes válidos."
                    } else {
                        null
                    }
                )
            } catch (exception: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Não foi possível carregar os filmes."
                )
            } finally {
                requestInFlight = false
            }
        }
    }

    fun swipeMovie(movie: Movie) {
        val state = _uiState.value
        if (state.movies.firstOrNull()?.id != movie.id) return

        _uiState.value = state.copy(
            movies = state.movies.drop(1),
            seenMovies = listOf(movie) + state.seenMovies
        )
        if (_uiState.value.movies.size < 3) fetchMovies()
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}