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
    val id: String,
    val name: String,
    val amount: Double,
    val categoryId: String,
    val period: String,
    val startDate: ZonedDateTime,
    val recurring: Boolean = true,
    val isPrimary: Boolean = false
)