package com.example.toscas_front.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.toscas_front.R
import com.example.toscas_front.ui.theme.OffBlack
import com.example.toscas_front.ui.theme.OffWhite
import com.example.toscas_front.ui.theme.Abel
import com.example.toscas_front.viewModel.MovieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MoviesPage(viewModel: MovieViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .background(OffBlack)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        if (state.seenMovies.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text("Nenhum filme visto ainda", color = OffWhite, fontFamily = Abel)
            }
        } else {
            LazyColumn {
                items(state.seenMovies, key = { it.id }) { movie ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(96.dp)
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row {
                            AsyncImage(
                                model = movie.posterUrl,
                                placeholder = androidx.compose.ui.res.painterResource(R.drawable.movie),
                                error = androidx.compose.ui.res.painterResource(R.drawable.movie),
                                contentDescription = movie.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth(0.28f)
                                    .fillMaxHeight()
                            )
                            Text(
                                text = movie.title,
                                color = Color.Black,
                                fontFamily = Abel,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MoviesPagePreview(){
    MoviesPage()
}