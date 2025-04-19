package com.pilsa.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.pilsa.ui.theme.color.ColorSet


private val LocalColors = staticCompositionLocalOf { ColorSet.Main.LightColors }

@Composable
fun PilSaTheme(
    myColors: ColorSet = ColorSet.Main,
    typography: Typography = Typography,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> myColors.DarkColors
        else -> myColors.LightColors
    }

    CompositionLocalProvider(LocalColors provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            typography = typography,
            content = content
        )
    }
}