package com.pilsa.ui.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pilsa.data.ui.CalendarDayItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar


class CalendarViewModel : ViewModel() {

    private val _dayItemFlow = MutableSharedFlow<List<CalendarDayItem>>()
    val dayItemFlow: SharedFlow<List<CalendarDayItem>> = _dayItemFlow.asSharedFlow()


    init {

    }

    fun generateMonthlyDates() {
        getDaysInMonth(5, 2025)
    }


    @SuppressLint("SimpleDateFormat")
    fun getDaysInMonth(year: Int, month: Int): List<String> {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, 1)

        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dateList = mutableListOf<String>()

        for (day in 1..daysInMonth) {
            calendar.set(year, month - 1, day)
            val date = calendar.time
            val formattedDate = SimpleDateFormat("dd").format(date)
            dateList.add(formattedDate)
        }

        return dateList
    }

    fun onDayItemSelected(item: List<CalendarDayItem>) {
        viewModelScope.launch {
            _dayItemFlow.emit(item)
        }
    }

    fun initForTest() {

    }

}