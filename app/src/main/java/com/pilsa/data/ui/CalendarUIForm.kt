package com.pilsa.data.ui

data class CalendarDayItem(
    val month: Int,
    val day: Int,
    val dayOfWeek: String,
    val isLiked: Boolean = false,
    val hasNote: Boolean = false,
    val noteContent: String = ""
)

data class CalendarSummary(
    val month: Int,
    val countWritten: Int,
    val countLiked: Int
)