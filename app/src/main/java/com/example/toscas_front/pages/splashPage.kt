package com.example.toscas_front.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.toscas_front.R
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    onFinished: () -> Unit
){
    LaunchedEffect(Unit) {
        delay(2000)
        onFinished()
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )
    }
}

@Preview
@Composable
fun SplashPagePreview(){
    SplashPage({})
}