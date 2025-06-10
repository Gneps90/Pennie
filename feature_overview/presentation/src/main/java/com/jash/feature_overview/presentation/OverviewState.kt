package com.jash.feature_overview.presentation

// Holds all the formatted strings and data for our screen
data class OverviewState(
    val formattedBalance: String = "£0.00",
    val formattedIncome: String = "£0.00",
    val formattedExpenses: String = "£0.00",
    val recentTransactions: List<TransactionUiModel> = emptyList(),
    val isLoading: Boolean = true

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
