package com.jash.feature_overview.domain

import com.jash.feature_overview.domain.OverviewRepository
import kotlinx.coroutines.flow.combine


class GetOverviewData(
    private val repository: OverviewRepository
) {
    val overviewDataFlow = combine(
        repository.getTotalBalance(),
        repository.getTotalIncome(),
        repository.getTotalExpenses(),
        repository.getRecentTransactions()
    ) { balance, income, expenses, transactions ->
        OverviewData(
            totalBalance = balance,
            totalIncome = income,
            totalExpenses = expenses,
            recentTransactions = transactions
        )
    }
}