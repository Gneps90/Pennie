package com.jash.feature_overview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jash.core.domain.Transaction
import com.jash.feature_overview.domain.GetOverviewData
import com.jash.feature_overview.domain.OverviewData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

class OverviewViewModel(
    getOverviewData: GetOverviewData
) : ViewModel() {


    val state = getOverviewData.overviewDataFlow
        .map(::toOverviewState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = OverviewState(isLoading = true)
        )


    private val _events = MutableSharedFlow<OverviewEvent>()
    val events = _events.asSharedFlow()


    fun onAction(action: OverviewAction) {
        viewModelScope.launch {
            when (action) {
                OverviewAction.OnLogoutClick -> {

                    _events.emit(OverviewEvent.OnLogout)
                }

                else -> Unit
            }
        }
    }


    private fun toOverviewState(data: OverviewData): OverviewState {
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK)
        val dateFormatter = DateTimeFormatter.ofPattern("dd MMM")

        val spentOnBudget = data.recentTransactions
            .filter { it.type == "EXPENSE" && it.category == data.activeBudget?.categoryId }
            .sumOf { it.amount }

        val budgetProgress = if (data.activeBudget != null && data.activeBudget!!.amount > 0) {
            (spentOnBudget / data.activeBudget!!.amount).toFloat()
        } else 0f

        return OverviewState(
            formattedBalance = currencyFormat.format(data.totalBalance),
            formattedIncome = currencyFormat.format(data.totalIncome),
            formattedExpenses = currencyFormat.format(data.totalExpenses),
            recentTransactions = data.recentTransactions.map {
                toTransactionUiModel(it, currencyFormat, dateFormatter)
            },
            isLoading = false,
            budget = data.activeBudget?.let { budget ->
                BudgetUiModel(
                    title = budget.name,
                    progress = budgetProgress,
                    percentageText = "${(budgetProgress * 100).toInt()}%",
                    amountText = "${currencyFormat.format(spentOnBudget)} / ${currencyFormat.format(budget.amount)}",
                    isLoading = false
                )
            }
        )
    }

    private fun toTransactionUiModel(
        transaction: Transaction,
        currencyFormat: NumberFormat,
        dateFormatter: DateTimeFormatter
    ): TransactionUiModel {
        return TransactionUiModel(
            id = transaction.id,
            description = transaction.description ?: "Transaction",
            amount = if (transaction.type == "INCOME") {
                "+${currencyFormat.format(transaction.amount)}"
            } else {
                "-${currencyFormat.format(transaction.amount)}"
            },
            category = transaction.category,
            date = transaction.date.format(dateFormatter),
        )
    }
}