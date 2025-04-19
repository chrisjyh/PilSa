package com.pilsa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pilsa.R


private val preBold = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold)
)

private val preRegular = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal)
)

private val preThin = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.Thin)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = preBold,
        fontSize = 32.sp,
        lineHeight = 48.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = preBold,
        fontSize = 28.sp,
        lineHeight = 42.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = preBold,
        fontSize = 24.sp,
        lineHeight = 36.sp
    ),
)

val Typography.headMediumSmall: TextStyle
    @Composable get() = headlineSmall.copy(
        fontSize = 20.sp,
        lineHeight = 30.sp
    )