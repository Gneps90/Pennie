package com.jash.feature_overview.domain

import com.jash.core.domain.Budget
import com.jash.core.domain.Transaction

data class OverviewData(
    val totalBalance: Double,
    val totalIncome: Double,
    val totalExpenses: Double,
    val recentTransactions: List<Transaction>,
    val activeBudget: Budget?
)