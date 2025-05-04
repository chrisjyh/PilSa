package com.pilsa.ui.view.CalendarScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pilsa.ui.theme.color.Colors

@Composable
fun CalendarView(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Main.background)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 30.dp),
    ) {
        Text("CalendarView Screen")
    }
}