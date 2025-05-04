package com.pilsa.ui.view.homeScreen

import android.graphics.Paint.Align
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.theme.color.ColorSet
import com.pilsa.ui.theme.color.Colors

@Composable
fun HomeView(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier
                        .weight(1f)
                        .height(120.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            color = Colors.Main.white,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Colors.Main.title)
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("2025.03")
                        Text("수요일")
                    }
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "25"

                    )
                }
                Spacer(Modifier.size(20.dp))
                Card (
                    modifier = Modifier
                        .weight(1f)
                        .height(120.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {

                }
            }


            Row {  }
        }
    }
}

@Preview()
@Composable
fun previewHome(){
    PilSaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .background(Colors.Main.background)
        ) {
            HomeView()
        }
    }
}