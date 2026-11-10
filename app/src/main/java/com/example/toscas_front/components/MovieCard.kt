package com.example.toscas_front.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toscas_front.ui.theme.Abel
import com.example.toscas_front.ui.theme.Blue
import com.example.toscas_front.ui.theme.HotWoodOneSC
import com.example.toscas_front.ui.theme.Pink

@Composable
fun movieCard(
    title: String,
    rate: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(8.dp),
    ){
        Box(
            modifier = Modifier
                .background(Pink)
                .size(100.dp)
        ){

        }

        Spacer(modifier = Modifier.width(16.dp))

        Column() {
            Text("$title", fontFamily = HotWoodOneSC, fontSize = 20.sp)
            Text("$rate/5", fontFamily = Abel, fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun movieCardPreview(){
    movieCard("Batman", 4)
}