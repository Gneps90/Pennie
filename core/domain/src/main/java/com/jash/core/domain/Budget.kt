package com.jash.core.domain

import java.time.ZonedDateTime

data class Budget(
    val id: String,
    val name: String,
    val amount: Double,
    val categoryId: String,
    val period: String,
    val startDate: ZonedDateTime,
    val recurring: Boolean
)