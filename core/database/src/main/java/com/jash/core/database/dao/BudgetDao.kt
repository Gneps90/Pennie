package com.jash.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.jash.core.database.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Upsert
    suspend fun upsertBudget(budget: BudgetEntity)

    @Query("SELECT * FROM budgets ORDER BY name ASC")
    fun getBudgetsFlow(): Flow<List<BudgetEntity>>


    @Query("SELECT * FROM budgets WHERE isPrimary = 1 LIMIT 1")
    fun getActiveBudget(): Flow<BudgetEntity?>

    @Query("DELETE FROM budgets WHERE id = :id")
    suspend fun deleteBudget(id: String)
}