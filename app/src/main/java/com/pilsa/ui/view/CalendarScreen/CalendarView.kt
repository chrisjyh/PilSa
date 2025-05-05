package com.pilsa.ui.view.CalendarScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pilsa.R
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors

@Composable
fun CalendarView(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Main.background)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 30.dp),
    ) {
        // 달력
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(396.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = Colors.Main.widgetBg,
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = Colors.Main.borderBg,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.size(24.dp),
                    text = "<",
                    color = Colors.Content.calendarContent
                )

                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = "2025. 03",
                    style = Typography.headlineMedium,
                    color = Colors.Content.calendarContent,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.size(24.dp),
                    text = ">",
                    color = Colors.Content.calendarContent
                )
            }
        }

        // 종합
        Row (
            modifier = Modifier.padding(vertical = 15.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ico_writed_blue),
                contentDescription = "wrote",
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "3",
                style = Typography.bodyMedium,
                color = Colors.Content.normal02
            )

            Spacer(
                modifier = Modifier.width(20.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ico_like_pink),
                contentDescription = "wrote",
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "3",
                style = Typography.bodyMedium,
                color = Colors.Content.normal02
            )
        }

        // 작성 내용
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = Colors.Main.white,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .padding(vertical = 6.dp, horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "21",
                    style = Typography.headlineMedium,
                    color = Colors.Content.calendarContent
                )
                Text(
                    text = "(목)",
                    style = Typography.headlineSmall,
                    color = Colors.Content.calendarContent
                )
            }
            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = "글자수 제한 몇자 정도가 좋을까요? 그리고 이 메모가 명언을 보고 느끼는 감상평 같은 걸까요?!",
                style = Typography.bodyMedium,
            )

        }
    }
}


@Preview()
@Composable
fun previewCalendar(){
    PilSaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, bottom = 60.dp)
                .background(Colors.Main.background)
        ) {
            CalendarView()
        }
    }
}