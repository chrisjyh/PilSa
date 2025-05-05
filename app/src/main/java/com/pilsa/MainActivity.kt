package com.pilsa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pilsa.ui.theme.PilSaTheme
import com.pilsa.ui.view.BottomNavigationApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PilSaTheme {
                BottomNavigationApp()
            }
        }
    }
}