package com.example.toscas_front.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.example.toscas_front.pages.MoviesPage
import com.example.toscas_front.pages.RandomPage
import com.example.toscas_front.pages.SplashPage

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    currentDestination: NavDestination?
){
    navigation<MainGraph>(startDestination = SplashRoute){
        composable<SplashRoute>(){
            SplashPage(
                onFinished = {
                    navController.navigate(MoviesRoute) {
                        popUpTo(SplashRoute) { inclusive = false}
                    }
                }
            )
        }

        composable<MoviesRoute> {
            MoviesPage()
        }
        composable<RandomRoute> {
            RandomPage()
        }
    }
}