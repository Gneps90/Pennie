package com.jash.feature_overview.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jash.feature_overview.domain.GetOverviewData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.text.NumberFormat
import java.util.Locale

class OverviewViewModel(
    getOverviewData: GetOverviewData
) : ViewModel() {

    val state = getOverviewData.overviewDataFlow
        .map { data ->
            val currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK)

            OverviewState(
                formattedBalance = currencyFormat.format(data.totalBalance),
                formattedIncome = currencyFormat.format(data.totalIncome),
                formattedExpenses = currencyFormat.format(data.totalExpenses),
                recentTransactions = data.recentTransactions.map {
                    TransactionUiModel(
                        id = it.id,
                        description = it.description ?: "Transaction",
                        amount = if(it.type == "INCOME") {
                            "+${currencyFormat.format(it.amount)}"
                        } else {
                            "-${currencyFormat.format(it.amount)}"
                        },
                        category = it.category,
                        date = "Today", // TODO: Implement a real date formatter
                    )
                },
                isLoading = false
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = OverviewState(isLoading = true)
        )
}