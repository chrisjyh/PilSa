package com.pilsa.ui.view.CalendarScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import java.time.LocalDate

@Composable
fun CalendarView(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Main.background)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 30.dp),
    ) {
        // 달력
        Calendar()

        // 종합
        ActingSummary(3,3)

        // 작성 내용
        WrittenScript("21", "글자수 제한 몇자 정도가 좋을까요? 그리고 이 메모가 명언을 보고 느끼는 감상평 같은 걸까요?!")
    }
}

@Composable
fun ActingSummary(wrote: Int, like: Int) {
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
            text = "$wrote",
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
            text = "$like",
            style = Typography.bodyMedium,
            color = Colors.Content.normal02
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calendar() {
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
        CalendarMonth()
        GridCalendar()

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GridCalendar() {
    val today = LocalDate.now()
    val year = today.year
    val month = today.month

    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val daysInMonth = firstDayOfMonth.lengthOfMonth()
    val startDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7

    // 날짜 리스트 만들기 (빈칸 포함)
    val calendarDates = buildList<LocalDate?> {
        repeat(startDayOfWeek) { add(null) } // 빈 칸
        for (day in 1..daysInMonth) {
            add(LocalDate.of(year, month, day))
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // 요일 헤더
        Row(modifier = Modifier.fillMaxWidth()) {
            listOf("일", "월", "화", "수", "목", "금", "토").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 날짜 그리드
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 500.dp),
            userScrollEnabled = false // 달력 높이 고정
        ) {
            items(calendarDates.size) { index ->
                val date = calendarDates[index]
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = date?.dayOfMonth?.toString() ?: "",
                        style = Typography.bodySmall
                    )
                }
            }
        }
    }
}



@Composable
fun CalendarMonth() {
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




@Composable
fun WrittenScript(date: String, script: String) {

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
            text = script,
            style = Typography.bodyMedium,
        )
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