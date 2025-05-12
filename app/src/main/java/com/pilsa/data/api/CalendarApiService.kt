package com.pilsa.data.api

import com.pilsa.data.module.CalendarData
import retrofit2.http.GET
import retrofit2.http.Query

interface CalendarApiService {

    @GET("/member-quotes/monthly")
    suspend fun getCalendarData(
        @Query("yearMonth") yearMonth: String
    ): CalendarData

}

