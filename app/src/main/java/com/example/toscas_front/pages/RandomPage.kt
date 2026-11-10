package com.example.toscas_front.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.toscas_front.components.ErrorWithRetry
import com.example.toscas_front.components.SwipeableMovieStack
import com.example.toscas_front.viewModel.MovieViewModel

@Composable
fun RandomPage(
    viewModel : MovieViewModel = viewModel()
){
    val state by viewModel.uiState.collectAsState()
    val error = state.error

    LaunchedEffect(state.movies.size, state.error) {
        if (state.movies.size < 3 && !state.isLoading && state.error == null) {
            viewModel.fetchMovies()
        }
    }

    when {
        state.movies.isNotEmpty() -> SwipeableMovieStack(
            movies = state.movies,
            onSwiped = viewModel::swipeMovie,
            modifier = Modifier.fillMaxSize()
        )
        error != null -> ErrorWithRetry(
            message = error,
            onRetry = viewModel::fetchMovies,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun RandomPagePreviw(){
    RandomPage()
}