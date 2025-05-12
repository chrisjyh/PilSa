package com.pilsa.ui.view.CalendarScreen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pilsa.data.ui.CalendarDayItem
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors
import com.pilsa.ui.viewModel.CalendarViewModel


@Composable
fun CalendarComponent(viewModel: CalendarViewModel) {
    val calendarDayItem by viewModel.dayItemFlow.collectAsState(initial = emptyList())

    Log.d("philsa", "calendarDayItem : ${calendarDayItem.size}")
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
        CalendarGrid(calendarDayItem)
    }
}


@Composable
fun CalendarGrid(
    calendarDates: List<CalendarDayItem>
) {
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
            userScrollEnabled = false
        ) {
            items(calendarDates.size) { index ->
                val item = calendarDates[index]
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.day.toString(),
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

