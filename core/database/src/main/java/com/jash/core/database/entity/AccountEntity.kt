package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val initialBalance: Double,
    val currency: String,
    val color: Int,
    val icon: String
)