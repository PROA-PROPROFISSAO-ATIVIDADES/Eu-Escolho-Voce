package com.example.toscas_front.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.example.toscas_front.R
import com.example.toscas_front.navigation.MoviesRoute
import com.example.toscas_front.navigation.RandomRoute
import com.example.toscas_front.ui.theme.Beige

@Composable
fun NavigationComponent(
    currentDestination: NavDestination?,
    onTabClick: (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    val isRandomPageSelected = currentDestination?.hasRoute<RandomRoute>() == true

    Row(
        modifier = modifier
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color.Black
            )
            .clip(RoundedCornerShape(20.dp))
            .background(Beige)
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = {
                onTabClick(RandomRoute)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.dice),
                contentDescription = "Dice",
                alpha = if
                    (isRandomPageSelected) 1f else 0.5f
            )
        }

        IconButton(
            onClick = {
                onTabClick(MoviesRoute)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.movie),
                contentDescription = "Movie",
                alpha = if
                    (!isRandomPageSelected) 1f else 0.5f
            )
        }
    }
}

@Preview
@Composable
fun NavigationComponentPreview(){
    NavigationComponent(
        modifier = Modifier,
        currentDestination = null,
        onTabClick = {}
    )
}