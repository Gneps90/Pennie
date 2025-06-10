package com.jash.core.presentation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pennie.core.presentation.designsystem.R

val Satoshi = FontFamily(
    Font(
        resId = R.font.satoshi_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.satoshi_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.satoshi_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.satoshi_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.satoshi_black,
        weight = FontWeight.Bold
    ),
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        color = PennieGray
    ),
    bodyMedium = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,

    ),
    labelMedium = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = PennieWhite
    ),
)