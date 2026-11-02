package com.example.toscas_front.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.toscas_front.R
import com.example.toscas_front.components.NavigationComponent
import com.example.toscas_front.ui.theme.OffBlack
import com.example.toscas_front.ui.theme.OffWhite
import com.example.toscas_front.ui.theme.RussoOne

@Composable
fun AppNavHost(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    val showNavigation = currentDestination?.hasRoute<SplashRoute>() == false
    val isMovieRoute = currentDestination?.hasRoute<MoviesRoute>() == true // ciente que não é boa pratica

    Scaffold(
        modifier = modifier
            .background(OffBlack),
        topBar = {
            if(isMovieRoute) (
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(R.drawable.logo_horizontal),
                        contentDescription = "Logo horizontal"
                    )
                }
            ) else {
                Text(
                    text = "Filme sorteado:",
                    fontFamily = RussoOne,
                    fontSize = 24.sp,
                    color = OffWhite,
                    modifier = Modifier.padding(16.dp)
                )
            }
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