package com.pilsa.ui.view.MypageScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pilsa.R
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.theme.Typography
import com.pilsa.ui.theme.color.Colors

@Composable
fun MyAppView(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        ProfileContent(
            painter = painterResource(id = R.drawable.ico_rock_img),
            text = "닉네임 or 연동된 계정 이름?"
        )
        Spacer(Modifier.size(30.dp))
        ButtonNotice(
            painterResource(id = R.drawable.ico_notice),
            "공지사항",
            true
        )
        Spacer(Modifier.size(12.dp))
        ButtonNotice(
            painterResource(id = R.drawable.ico_bell),
            "알림",
            true
        )
        Spacer(Modifier.size(12.dp))
        ButtonNotice(
            painterResource(id = R.drawable.ico_theme),
            "테마",
            false
        )
        Spacer(Modifier.size(50.dp))


    }
}

@Composable
fun ButtonNotice(icon: Painter, text: String, arrow: Boolean){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Colors.Main.white02, shape = RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Colors.Content.border,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 13.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(20.dp).padding(end = 8.dp),
            tint = Colors.Btn.purple
        )
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = Typography.bodyLarge
        )
        if (arrow) {
            Icon(
                painter = painterResource(id = R.drawable.ico_arrow_toright),
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = Colors.Content.normal
            )
        }
    }
}

@Composable
fun ProfileContent(painter: Painter, text: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Colors.Main.white, shape = RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = Colors.Content.border,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 15.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = "Rounded Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .padding(end = 16.dp)
        )
        Text(
            text = text,
            style = Typography.bodyLarge
        )
    }
}


@Preview()
@Composable
fun previewMyPage(){
    PilSaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, bottom = 60.dp)
                .background(Colors.Main.background)
        ) {
            MyAppView ()
        }
    }
}