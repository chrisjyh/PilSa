package com.pilsa.ui.view.CalendarScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.theme.color.Colors
import com.pilsa.ui.view.CalendarScreen.components.CalendarComponent
import com.pilsa.ui.view.CalendarScreen.components.CalendarSummary
import com.pilsa.ui.view.CalendarScreen.components.WrittenScript
import com.pilsa.ui.viewModel.CalendarViewModel

@Composable
fun CalendarView(){
    val viewModel: CalendarViewModel = hiltViewModel()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Main.background)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 30.dp),
    ) {
        // 달력
        CalendarComponent(viewModel)

        // 종합
        CalendarSummary(3,3)

        // 작성 내용
        WrittenScript("21", "글자수 제한 몇자 정도가 좋을까요? 그리고 이 메모가 명언을 보고 느끼는 감상평 같은 걸까요?!")
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