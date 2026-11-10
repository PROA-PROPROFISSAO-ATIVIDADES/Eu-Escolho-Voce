package com.example.toscas_front.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toscas_front.R
import coil3.compose.AsyncImage
import com.example.toscas_front.data.model.Movie
import com.example.toscas_front.ui.theme.Abel
import com.example.toscas_front.ui.theme.HotWoodOneSC
import com.example.toscas_front.ui.theme.OffWhite
import com.example.toscas_front.ui.theme.Pink
import com.example.toscas_front.ui.theme.Purple
import java.util.Locale

@Composable
fun MoviePreview(
    movie: Movie?,
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
    ){
        MovieBackgroundPreview()

        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.12f)
                .offset(x = 30.dp, y = 0.dp)
                .background(Purple, shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                ))
                .align(Alignment.TopEnd)
        ){}

        Box(
            modifier = Modifier
                .fillMaxHeight(0.85f)
                .fillMaxWidth()
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
                .padding(16.dp),
            contentAlignment = Alignment.Center

        ) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(Pink)
                    .align(Alignment.TopStart),
                model = movie?.posterUrl,
                placeholder = androidx.compose.ui.res.painterResource(R.drawable.movie),
                error = androidx.compose.ui.res.painterResource(R.drawable.movie),
                contentScale = ContentScale.Crop,
                contentDescription = "${movie?.title} - poster"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text("${movie?.title}", fontFamily = HotWoodOneSC, fontSize = 20.sp, color = OffWhite)
                Text(
                    text = movie?.rate?.let {
                        String.format(Locale.getDefault(), "%.1f/5", (it / 2.0).coerceIn(0.0, 5.0))
                    } ?: "0.0/5",
                    fontFamily = Abel,
                    fontSize = 20.sp,
                    color = OffWhite
                )
            }
        }
    }
}

@Composable
fun MovieBackgroundPreview(
    modifer: Modifier = Modifier
        .fillMaxSize()
){
    Box(
        modifier = Modifier
            .fillMaxHeight(0.85f)
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color.Black
            )
            .background(Pink, shape = RoundedCornerShape(
                topStart = 20.dp
            ))
    ) {}
}

@Preview
@Composable
fun MoviePreviewPreview(){
    MoviePreview(
        Movie(0, "BATMAN", 4.0, null)
    )
}

@Preview
@Composable
fun MovieBackgrounfPreview(){
    MovieBackgroundPreview()
}