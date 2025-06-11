package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val amount: Double,
    val type: String,
    val category: String,
    val description: String?,
    val date: ZonedDateTime,
    val accountId: String
)