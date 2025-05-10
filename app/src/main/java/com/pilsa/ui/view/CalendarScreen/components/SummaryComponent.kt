package com.pilsa.ui.view.CalendarScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pilsa.R
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors


@Composable
fun CalendarSummary(wrote: Int, like: Int) {
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
