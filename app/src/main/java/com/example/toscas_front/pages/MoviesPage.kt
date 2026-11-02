package com.example.toscas_front.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.example.toscas_front.components.NavigationComponent
import com.example.toscas_front.ui.theme.OffBlack
import com.example.toscas_front.ui.theme.OffWhite

@Composable
fun MoviesPage() {
    Column(
        modifier = Modifier
            .background(OffBlack)
            .fillMaxSize()
            .padding(8.dp)
    ) {

    }
}

@Preview
@Composable
fun MoviesPagePreview(){
    MoviesPage()
}