package com.example.toscas_front.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toscas_front.ui.theme.Abel
import com.example.toscas_front.ui.theme.Beige
import com.example.toscas_front.ui.theme.OffBlack
import com.example.toscas_front.ui.theme.OffWhite

@Composable
fun ErrorWithRetry(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = message,
            color = OffWhite,
            fontFamily = Abel,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = Beige,
                contentColor = OffBlack
            )
        ) {
            Text("Tentar novamente", fontFamily = Abel, fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
fun ErrorWithRetryPreview() {
    ErrorWithRetry(message = "Não foi possível carregar os filmes.", onRetry = {})
}
