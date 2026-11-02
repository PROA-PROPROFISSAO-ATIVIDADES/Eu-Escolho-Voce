package com.example.toscas_front.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.toscas_front.R

val RussoOne = FontFamily(
    Font(R.font.russo_one_regular, FontWeight.Normal)
)

val Abel = FontFamily(
    Font(R.font.abel_regular, FontWeight.Normal)
)

val HotWoodOneSC = FontFamily(
    Font(R.font.holtwood_one_sc_regular, FontWeight.Normal)
)

val Typography = Typography(

    headlineLarge = TextStyle(
        fontFamily = RussoOne,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = HotWoodOneSC,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = Abel,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)