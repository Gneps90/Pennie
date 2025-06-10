package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String, // Using String for ID is flexible, e.g., for UUIDs
    val amount: Double,
    val type: String, // e.g., "INCOME", "EXPENSE"
    val category: String, // e.g., "Groceries", "Salary"
    val description: String?,
    val date: ZonedDateTime,
    val accountId: String
)