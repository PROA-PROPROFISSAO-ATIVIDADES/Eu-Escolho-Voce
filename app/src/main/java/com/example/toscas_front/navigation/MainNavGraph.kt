package com.example.toscas_front.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.toscas_front.pages.MoviesPage
import com.example.toscas_front.pages.RandomPage
import com.example.toscas_front.pages.SplashPage
import com.example.toscas_front.viewModel.MovieViewModel

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    movieViewModel: MovieViewModel
){
    navigation<MainGraph>(startDestination = SplashRoute){
        composable<SplashRoute>(){
            SplashPage(
                onFinished = {
                    navController.navigate(MoviesRoute) {
                        popUpTo(SplashRoute) { inclusive = true}
                    }
                }
            )
        }

        composable<MoviesRoute> {
            MoviesPage(movieViewModel)
        }
        composable<RandomRoute> {
            RandomPage(movieViewModel)
        }
    }
}