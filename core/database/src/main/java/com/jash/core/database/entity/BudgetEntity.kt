package com.jash.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.jash.core.database.entity.CategoryEntity
import java.time.ZonedDateTime

@Entity(
    tableName = "budgets",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BudgetEntity(
    @PrimaryKey
    val id: String, // e.g., a UUID string
    val name: String,
    val amount: Double, // The total budget amount
    val categoryId: String, // Links to a specific category
    val period: String, // e.g., "MONTHLY", "WEEKLY", "YEARLY"
    val startDate: ZonedDateTime,
    val recurring: Boolean = true // Does this budget repeat?
)