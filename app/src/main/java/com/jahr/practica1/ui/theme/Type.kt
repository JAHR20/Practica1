package com.jahr.practica1.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jahr.practica1.R

private val rubik = FontFamily(
    Font(R.font.rubikbold, weight = FontWeight.Bold ),
    Font(R.font.rubikmedium, weight = FontWeight.Medium ),
    Font(R.font.rubikregular, weight = FontWeight.Normal )

)

private val outfit = FontFamily(
    Font(R.font.outfitregular, weight = FontWeight.Normal )

)
// Set of Material typography styles to start with
val Typography = Typography(

    titleLarge = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp
    ),

    titleMedium = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = outfit,
        fontWeight = FontWeight.Normal,
        fontSize = 56.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)