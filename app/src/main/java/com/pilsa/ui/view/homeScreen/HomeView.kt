package com.pilsa.ui.view.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pilsa.R
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors
import com.pilsa.ui.view.LogoArea

@Composable
fun HomeView() {
    LogoArea{
        HomeContent()
    }
}

@Composable
fun HomeContent(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // 날짜 및 이미지 선택 위젯
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Colors.Main.title)
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "2025.03",
                        style = Typography.headlineSmall
                    )
                    Text(
                        text = "수요일",
                        style = Typography.headlineSmall
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "25",
                    style = Typography.headlineLarge

                )
            }
            Spacer(Modifier.size(20.dp))
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                shape = RoundedCornerShape(12.dp)
            ) {

            }
        }
        // 한영
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextInsideSwitch()
        }
        // 필사 영역
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = Colors.Main.widgetBg,
                    shape = RoundedCornerShape(12.dp)
                )
                .alpha(0.7f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_writing_line),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(Modifier.size(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ico_copy),
                contentDescription = "copy",
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ico_share),
                contentDescription = "share",
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .size(24.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ico_like),
                contentDescription = "like",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun TextInsideSwitch() {
    var isChecked by remember { mutableStateOf(false) }

    val switchWidth = 60.dp
    val switchHeight = 28.dp
    val thumbSize = 29.dp

    Box(
        modifier = Modifier
            .width(switchWidth)
            .height(switchHeight)
            .clip(RoundedCornerShape(20.dp))
            .background(if (isChecked) Colors.Main.item else Colors.Btn.white)
            .clickable { isChecked = !isChecked }
            .padding(2.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // 텍스트 레이어
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "한")
            Text(text = "영")
        }

        Box(
            modifier = Modifier
                .offset(x = if (isChecked) (switchWidth - thumbSize - 4.dp) else 0.dp)
                .size(thumbSize)
                .background(Colors.Btn.purple, shape = CircleShape)
        )
    }
}

@Preview()
@Composable
fun previewHome(){
    PilSaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, bottom = 60.dp)
                .background(Colors.Main.background)
        ) {
            HomeView()
        }
    }
}