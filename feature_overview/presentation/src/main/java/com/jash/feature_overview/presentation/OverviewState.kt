package com.jash.feature_overview.presentation

import com.jash.core.domain.Budget

// Holds all the formatted strings and data for our screen
data class OverviewState(
    val formattedBalance: String = "£0.00",
    val formattedIncome: String = "£0.00",
    val formattedExpenses: String = "£0.00",
    val recentTransactions: List<TransactionUiModel> = emptyList(),
    val isLoading: Boolean = true,
    val activeBudget: Budget? = null
)

// Represents a single transaction item in the UI list
data class TransactionUiModel(
    val id: String,
    val description: String,
    val amount: String,
    val category: String,
    val date: String,
    val icon: Any // Placeholder for an icon resource
)

data class BudgetUiModel(
    val budgetTitle: String = "Monthly Budget",
    val budgetProgress: Float = 0f,
    val budgetPercentageText: String = "0%",
    val budgetAmountText: String = "£0 / £0",
    val isLoading: Boolean = true
)
