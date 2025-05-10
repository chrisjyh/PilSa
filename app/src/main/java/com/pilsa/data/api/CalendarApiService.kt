package com.pilsa.data.api

import retrofit2.http.GET

interface CalendarApiService {

    @GET("/member-quotes/monthly/{yearMonth}")
    suspend fun getCalendarData(yearMonth: String): List<CalendarData>
}

