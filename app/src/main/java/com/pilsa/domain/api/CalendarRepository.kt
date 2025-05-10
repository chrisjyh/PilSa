package com.pilsa.domain.api

import android.util.Log
import com.pilsa.data.api.CalendarApiService
import javax.inject.Inject

class CalendarRepository @Inject constructor(
    val calendarApiService: CalendarApiService
) {
    suspend fun getCalendarData(yearMonth: String) {
        val result = calendarApiService.getCalendarData(yearMonth)
        Log.d("Philsa", "result: $result")
    }

}