package com.pilsa.ui.view.CalendarScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors


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