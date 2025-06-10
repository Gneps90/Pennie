package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey
    val id: String, // e.g., a UUID string
    val name: String,
    val type: String, // "INCOME" or "EXPENSE"
    val icon: String // A string identifier for the icon, e.g., "ic_category_groceries"
)