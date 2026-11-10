package com.example.toscas_front.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toscas_front.ui.theme.Pink
import com.example.toscas_front.ui.theme.Purple

@Composable
fun MoviePreview(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
    ){
        MovieBackgroundPreview()

        Box(
            modifier = Modifier
                .size(600.dp)
                .offset(x = 30.dp,y = (-30).dp)
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(20.dp),
                    spotColor = Color.Black
                )
                .fillMaxSize()
                .background(
                    Purple, shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                ))
        ) {}
    }
}

@Composable
fun MovieBackgroundPreview(
    modifer: Modifier = Modifier
        .fillMaxSize()
){
    Box(
        modifier = Modifier
            .size(700.dp)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color.Black
            )
            .fillMaxSize()
            .background(Pink, shape = RoundedCornerShape(
                topStart = 20.dp
            ))
    ) {}
}

@Preview
@Composable
fun MoviePreviewPreview(){
    MoviePreview()
}

@Preview
@Composable
fun MovieBackgrounfPreview(){
    MovieBackgroundPreview()
}