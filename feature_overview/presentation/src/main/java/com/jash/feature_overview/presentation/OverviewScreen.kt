@file:OptIn(ExperimentalMaterial3Api::class)

package com.jash.feature_overview.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.jash.core.presentation.designsystem.LogoIcon
import com.jash.core.presentation.designsystem.LogoutIcon
import com.jash.core.presentation.designsystem.PennieTheme

import com.jash.core.presentation.designsystem.componants.PennieScaffold
import com.jash.core.presentation.designsystem.componants.PennieToolbar
import com.jash.core.presentation.designsystem.componants.utils.DropDownItem
import com.jash.feature_overview.presentation.componants.BudgetTracker
import com.jash.feature_overview.presentation.componants.TotalBalanceCard
import com.jash.feature_overview.presentation.componants.TransactionListItem
import com.pennie.feature_overview.presentation.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen(
    stateFlow: StateFlow<OverviewState>,
    onAction: (OverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    val state by stateFlow.collectAsState()

    PennieScaffold(
        topAppbar = {
            PennieToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.dashboard),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.log_out),
                    ),
                ),
                onMenuItemClick = { index ->
                    when (index){
                        //0 -> onAction(OverviewAction.OnAnalyticsClick)
                        0 -> onAction(OverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },

        ) { paddingValues ->

        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = paddingValues
            )
            {
                item {
                    TotalBalanceCard(
                        modifier = Modifier.fillMaxWidth(),
                        totalBalance = state.formattedBalance,
                        income = state.formattedIncome,
                        expenses = state.formattedExpenses,
                        onViewAllClick = { /* TODO */ }
                    )
                }
                state.budget?.let {
                    item {
                        BudgetTracker(
                            title = it.title,
                            progress = it.progress,
                            percentageText = it.percentageText,
                            amountText = it.amountText
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Recent Transactions",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        TextButton(onClick = { /* TODO: Navigate to all transactions */ }) {
                            Text(text = "View All")
                        }

                    }
                }
                items(state.recentTransactions) { transaction ->
                    TransactionListItem(transaction = transaction)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OverviewScreenPreview() {
    PennieTheme {
        // 1. Create a sample state with data for the preview.
        val sampleState = OverviewState(
            formattedBalance = "£1,250.75",
            formattedIncome = "£2,100.00",
            formattedExpenses = "£849.25",
            isLoading = false,
            budget = BudgetUiModel(
                title = "Monthly Food Budget",
                progress = 0.65f,
                percentageText = "65%",
                amountText = "£325.00 / £500.00",
                isLoading = false
            ),
            recentTransactions = listOf(
                TransactionUiModel(
                    id = "1",
                    description = "Grocery Shopping",
                    amount = "-£75.50",
                    category = "Food",
                    date = "10 Jun"
                ),
                TransactionUiModel(
                    id = "2",
                    description = "Salary",
                    amount = "+£2,100.00",
                    category = "Salary",
                    date = "09 Jun"
                ),
                TransactionUiModel(
                    id = "3",
                    description = "Cinema Tickets",
                    amount = "-£24.00",
                    category = "Entertainment",
                    date = "08 Jun"
                )
            )
        )


        val sampleStateFlow = remember { MutableStateFlow(sampleState) }


        OverviewScreen(
            stateFlow = sampleStateFlow,
            onAction = {}
        )
    }
}
