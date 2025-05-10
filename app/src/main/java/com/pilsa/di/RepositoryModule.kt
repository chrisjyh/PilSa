package com.pilsa.di

import com.pilsa.data.api.CalendarApiService
import com.pilsa.domain.api.CalendarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideCalendarRepository(calendarApiService: CalendarApiService): CalendarRepository {
        return CalendarRepository(calendarApiService)
    }

}