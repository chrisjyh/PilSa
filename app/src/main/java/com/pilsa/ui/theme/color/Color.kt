package com.pilsa.ui.theme.color

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Black01 = Color(0xFF000000)
val Black02 = Color(0xFF212121)

val White01 = Color(0xFFFFFFFF)
val White02 = Color(0xFFFFF7E6)

val Gray01 = Color(0xFFBDBDBD)
val Gray02 = Color(0xFFCACACA)

val Yellow01 = Color(0xFFFFEFCC)
val Yellow02 = Color(0xFFFFF7E6)
val Yellow03 = Color(0xFFFFCB5C)

val Purple01 = Color(0xFF5C65FF)
val Purple02 = Color(0xFFD3D5FF)
val Purple03 = Color(0xFF5C65FF)

val Pink = Color(0xFFFF3D9E)

val Green01 = Color(0xFF1ACE35)

sealed class ColorSet {
    open lateinit var LightColors: MyColors
    open lateinit var DarkColors: MyColors

    data object Main: ColorSet(){
        override var LightColors = MyColors(
            material = lightColorScheme(
                primary = Purple01,
                onPrimary = White01,
                secondary = Purple02,
                onSecondary = Black01,
                background = Yellow01
            ),
            success = Green01
        )
        override var DarkColors = MyColors(
            material = lightColorScheme(
                primary = Purple01,
                onPrimary = White01,
                secondary = Purple02,
                onSecondary = Black01,
                background = Yellow01
            ),
            success = Green01
        )
    }
}

sealed class Colors {
    data object Main {
        val background = Yellow01
        val widgetBg = Yellow02
        val borderBg = Yellow03
        val title = Purple02
        val white = White01
        val white02 = White02
        val item = White02
    }

    data object Content  {
        val normal = Black01
        val normal02 = Black02
        val focus = White01
        val placeholder = Gray02
        val calendarContent = Purple01
        val border= Purple02
    }

    data object Btn {
        val purple = Purple03
        val black = Black02
        val white = White01
    }
}