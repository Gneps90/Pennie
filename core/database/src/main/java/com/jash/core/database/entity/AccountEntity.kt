package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey
    val id: String, // e.g., a UUID string
    val name: String,
    val initialBalance: Double,
    val currency: String, // e.g., "GBP", "USD"
    val color: Int, // Store the color as an integer (e.g., 0xFFFF0000 for red)
    val icon: String // A string identifier for the icon, e.g., "ic_account_balance"
)