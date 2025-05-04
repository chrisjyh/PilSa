package com.pilsa.ui.view.homeScreen

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pilsa.ui.theme.PilSaTheme

@Composable
fun HomeView(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("home Screen")
    }
}

@Preview
@Composable
fun previewHome(){
    PilSaTheme {
        HomeView()
    }
}