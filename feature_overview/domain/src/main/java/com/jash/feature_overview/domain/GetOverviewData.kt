package com.jash.feature_overview.domain


import kotlinx.coroutines.flow.combine

class GetOverviewData(
    private val repository: OverviewRepository
) {

    val overviewDataFlow = combine(
        repository.getTotalBalance(),
        repository.getTotalIncome(),
        repository.getTotalExpenses(),
        repository.getRecentTransactions(),
        repository.getActiveBudget()
    ) { balance, income, expenses, transactions, budget ->
        OverviewData(
            totalBalance = balance,
            totalIncome = income,
            totalExpenses = expenses,
            recentTransactions = transactions,
            activeBudget = budget
        )
    }
}