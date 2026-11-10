package com.example.toscas_front.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.toscas_front.components.NavigationComponent
import com.example.toscas_front.ui.theme.OffBlack
import com.example.toscas_front.ui.theme.OffWhite

@Composable
fun AppNavHost(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    val showNavigation = currentDestination?.hasRoute<SplashRoute>() == false

    val currentTitle = when {
        currentDestination?.hasRoute<MoviesRoute>() == true -> "Filme sorteado"
        currentDestination?.hasRoute<RandomRoute>() == true -> "Toscos"
        else -> ""
    }

    Scaffold(
        modifier = modifier
            .background(OffBlack),
        topBar = {
            Text(
                text = currentTitle,
                color = OffWhite,
                modifier = Modifier.padding(16.dp)
            )
        },
        bottomBar = {
            if(showNavigation){
                NavigationComponent(
                    currentDestination = currentDestination,
                    onTabClick = { route ->
                        navController.navigate(route)
                    }
                )
            }
        }
    ) { innerpadding ->
        NavHost(
            navController = navController,
            startDestination = MainGraph,
            modifier = modifier
                .padding(innerpadding)
        ) {
            mainNavGraph(navController, currentDestination)
        }
    }
}