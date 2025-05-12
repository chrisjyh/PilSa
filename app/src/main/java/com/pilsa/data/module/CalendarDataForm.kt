package com.pilsa.data.module

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarData(
    @SerialName("memberQuotes")
    val memberQuotes: List<MemberQuote>,
    @SerialName("monthlySummary")
    val monthlySummary: MonthlySummary,
)


@Serializable
data class MemberQuote(
    val dailyQuoteSeq: Int,
    val quoteDate: String,
    val quote: String,
    val author: String,
    val typingYn: String,
    val likeYn: String
)

@Serializable
data class MonthlySummary(
    val typingCount: Int,
    val likeCount: Int
)
