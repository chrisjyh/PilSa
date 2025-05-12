package com.pilsa.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pilsa.data.ui.CalendarDayItem
import com.pilsa.domain.api.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val repository: CalendarRepository
): ViewModel() {

    private val _dayItemFlow = MutableStateFlow<List<CalendarDayItem>>(emptyList())
    val dayItemFlow: SharedFlow<List<CalendarDayItem>> = _dayItemFlow


    init {
        generateMonthlyDates()
        getCalendar()
    }

    private fun getCalendar() {
        viewModelScope.launch {
            repository.getCalendarData("2025-05")
        }
    }

    private fun generateMonthlyDates() {
        val data = getDaysInMonth(5, 2025)

        onDayItemSelected(data)
    }


    @SuppressLint("SimpleDateFormat")
    fun getDaysInMonth(year: Int, month: Int): List<CalendarDayItem> {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, 1)

        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dateList = mutableListOf<CalendarDayItem>()

        for (day in 1..daysInMonth) {
            calendar.set(year, month - 1, day)
            val date = calendar.time
            val dayOfWeek = getDayOfWeekLegacy(year, month, day)
            val formattedDate = CalendarDayItem(
                month = month,
                day = SimpleDateFormat("dd").format(date).toInt(),
                dayOfWeek = dayOfWeek,
                isLiked = false,
                hasNote = false,
                noteContent = ""
            )
            dateList.add(formattedDate)
        }

        return dateList
    }


    fun getDayOfWeekLegacy(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance().apply {
            set(year, month - 1, day)
        }

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        return when (dayOfWeek) {
            Calendar.SUNDAY -> "Su"
            Calendar.MONDAY -> "Mo"
            Calendar.TUESDAY -> "Tu"
            Calendar.WEDNESDAY -> "We"
            Calendar.THURSDAY -> "Th"
            Calendar.FRIDAY -> "Fr"
            Calendar.SATURDAY -> "Sa"
            else -> "NA"
        }
    }

    fun onDayItemSelected(item: List<CalendarDayItem>) {
        viewModelScope.launch {
            _dayItemFlow.value = item
        }
    }

    fun initForTest() {

    }

}