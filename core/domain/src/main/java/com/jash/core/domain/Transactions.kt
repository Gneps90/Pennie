package com.jash.core.domain

import java.time.ZonedDateTime


data class Transaction(
    val id: String,
    val amount: Double,
    val type: String, // Income or Expense
    val category: String,
    val description: String?,
    val date: ZonedDateTime,
    val accountId: String
)