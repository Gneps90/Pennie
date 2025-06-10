package com.jash.feature_overview.domain

import com.jash.core.domain.Transaction
import kotlinx.coroutines.flow.Flow


interface OverviewRepository {
    fun getRecentTransactions(): Flow<List<Transaction>>
    fun getTotalBalance(): Flow<Double>
    fun getTotalIncome(): Flow<Double>
    fun getTotalExpenses(): Flow<Double>
}